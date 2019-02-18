package innerclasses.controller;

public abstract class Event {

    private long eventTime;
    protected final long delayTime;
    public Event(long delayTime) {
        this.delayTime = delayTime;
        start(); //调用start()方法给eventTime赋值
    }
    public void start() { // Allows restarting
        eventTime = System.nanoTime() + delayTime; //触发时间 = 系统当前时间 + 延迟时间
    }
    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }
    public abstract void action();
}
