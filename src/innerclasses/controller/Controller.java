package innerclasses.controller;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    // A class from java.util to hold Event objects:
    private List<Event> eventList = new ArrayList<Event>();
    public void addEvent(Event c) { //添加事件对象
        eventList.add(c);
    }
    public void run() {
        while(eventList.size() > 0)
        // Make a copy so you’re not modifying the list
        // while you’re selecting the elements in it:
            for(Event e : new ArrayList<Event>(eventList)){
                if(e.ready()) { //当系统时间大于触发时间时，触发事件并从list移除该事件对象
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
    }
}
