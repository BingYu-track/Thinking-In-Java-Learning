package innerclasses.controller;

public class GreenhouseControls extends Controller{

    private boolean light = false;

    public class LightOn extends Event { //继承Event
        public LightOn(long delayTime) {
            super(delayTime);
        }
        public void action() { //开灯
        // Put hardware control code here to physically turn on the light.
            light = true;
        }
        public String toString() {
            return "Light is on";
        }
    }

    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }
        public void action() { //关灯
        // Put hardware control code here to physically turn off the light.
            light = false;
        }
        public String toString() {
            return "Light is off";
        }
    }

    private boolean water = false;

    public class WaterOn extends Event {
        public WaterOn(long delayTime) { super(delayTime); }
        public void action() {
        // Put hardware control code here.
            water = true;
        }
        public String toString() {
            return "Greenhouse water is on";
        }
    }

    public class WaterOff extends Event {
        public WaterOff(long delayTime) { super(delayTime); }
        public void action() {
        // Put hardware control code here.
            water = false;
        }
        public String toString() {
            return "Greenhouse water is off";
        }
    }

    private String thermostat = "Day"; //温度调节器

    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }
        public void action() {
        // Put hardware control code here.
            thermostat = "Night";
        }
        public String toString() {
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime); //初始化触发时间
        }
        public void action() {
        // Put hardware control code here.
            thermostat = "Day";
        }
        public String toString() {
            return "Thermostat on day setting";
        }
    }

    // An example of an action() that inserts a
    // new one of itself into the event list:
    public class Bell extends Event {
        public Bell(long delayTime) { super(delayTime); }
        public void action() {
            addEvent(new Bell(delayTime));
        }
        public String toString() { return "Bing!"; }
    }

    /**
     * 用来储存所有的事件对象
     */
    public class Restart extends Event {
        private Event[] eventList; //内部类定义了Event数组
        public Restart(long delayTime, Event[] eventList) { //2000,eventList
            super(delayTime);
            this.eventList = eventList;
            for(Event e : eventList)
                addEvent(e);  //调用外部类继承的方法，将Event数组里的元素添加到外部类父类的eventList
        }
        //由于之前创建Restart对象时，eventList里的元素已经保存在了Restart的Event[]数组里，因此，这里action是重新将移除的元素添加进去
        public void action() {
            for(Event e : eventList) {
                e.start(); // Rerun each event
                addEvent(e);
            }
            start(); // Rerun this Event
            addEvent(this);
        }
        public String toString() {
            return "Restarting system";
        }
    }

    //停止
    public static class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }
        public void action() {
            System.exit(0); //退出程序
        }
        public String toString() {
            return "Terminating";
        }
    }
}
