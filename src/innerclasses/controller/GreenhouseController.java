package innerclasses.controller;

public class GreenhouseController {

    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        //为gc添加所有相应的事件
        gc.addEvent(gc.new Bell(900));  //创建了内部类对象Bell
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400)
        };
        gc.addEvent(gc.new Restart(2000, eventList)); //设置延迟时间并将之前的所有事件和新创建的Restart也放进事件列表当中
        if(args.length == 1){
            gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0]))); //创建嵌套内部类对象
        }
        gc.run();
    }
}
