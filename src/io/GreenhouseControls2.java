package io;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;
import innerclasses.controller.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @version 1.0
 * @Description: 从文本文件读取事件以及相关时间
 * @author: hxw
 * @date: 2019/2/15 17:28
 */
public class GreenhouseControls2 extends GreenhouseControls {

    /**
     *
     */
    class Restart extends Event {
        private Event[] eventList;
        public Restart(long delayTime) {
            super(delayTime);
        }

        public void action() {
            for(Event e : eventList) {
                e.start(); // Rerun each event 返回
                addEvent(e);
            }
            start();
            addEvent(this); // Rerun this Event
        }

        public String toString() {
            return "Restarting system";
        }
        public void setEventList(Event[] eventList) { //这里对Event[]数组赋值
            this.eventList = eventList;
        }

    }

    /**
     * 工厂模式 GHEventFactory内部类 ----事件工厂
     */
    class GHEventFactory {
        LinkedList<EventCreator> events = new LinkedList<EventCreator>();


        class EventCreator {
            Constructor<Event> ctor;
            long offset;
            public EventCreator(Constructor<Event> ctor, long offset) {
                this.ctor = ctor;
                this.offset = offset;
            }
        }

        @SuppressWarnings("unchecked")
        public GHEventFactory(String eventFile) {
            try {
                BufferedReader in = new BufferedReader(new FileReader(eventFile));
                String s;
                while((s = in.readLine())!= null) { //读取一行数据
                    int colon = s.indexOf(':'); //获取':'所在字符串的位置
                    // Must use '$' instead of '.' to describe inner classes:
                    String className = s.substring(0, colon).trim(); //获取配置文件里的事件类名
                    //如果当前读取的配置文件中的行为Restart，则使用GreenhouseControls2.class，其它使用GreenhouseControls.class
                    Class<?> outer = className.equals("Restart") ? GreenhouseControls2.class : GreenhouseControls.class;
                    String type = outer.getCanonicalName() + "$" + className; //拼接内部类名称
                    long offset = Long.parseLong(s.substring(colon + 1).trim()); //将冒号后面的数字解析成long值
                    // Use Reflection to find and call the right constructor: 通过反射根据类名获取事件的Class对象
                    Class<Event> eventClass = (Class<Event>)Class.forName(type); //这里报错，因为不是全限定性类名
                    // Inner class constructors implicitly take the outer-class object as a first argument:
                    Constructor<Event> ctor = eventClass.getConstructor(new Class<?>[] { outer, long.class });
                    events.add(new EventCreator(ctor, offset));
                }
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        }

        Iterator<Event> iterator() {
            //匿名内部类实现Iterator
            return new Iterator<Event>() {

                Iterator<EventCreator> it = events.iterator();

                public boolean hasNext() {
                    return it.hasNext();
                }

                public Event next() {
                    EventCreator ec = it.next();
                    Event returnVal = null;
                    try {
                        returnVal = ec.ctor.newInstance(new Object[] {GreenhouseControls2.this, ec.offset});
                    } catch(Exception e) {
                        throw new RuntimeException(e);
                    }
                    return returnVal;
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

    }

    GHEventFactory gheFactory;

    //构造器
    public GreenhouseControls2(String initFile) {
        gheFactory = new GHEventFactory(initFile); //初始化事件工厂
        // Now we need some logic to setup the system.The restart event requires a special attention. 现在我们需要一些逻辑来设置系统，重新启动事件需要特别注意
        LinkedList<Event> restartableEvents = new LinkedList<Event>();
        Iterator<Event> it = gheFactory.iterator();
        while(it.hasNext()) {
            Event e = it.next();
            if(e instanceof Bell || e instanceof Restart){
                continue;
            }
            restartableEvents.add(e);
        }
        it = gheFactory.iterator();
        while(it.hasNext()) {
            Event e = it.next();
            addEvent(e);
            if(e instanceof Restart)
                ((Restart)e).setEventList(restartableEvents.toArray(new Event[0]));
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class<Event> eventClass = (Class<Event>)Class.forName("GreenhouseControls$ThermostatNight");
    }
}
