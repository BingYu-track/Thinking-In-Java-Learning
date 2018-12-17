package generics.mix.decorator;

import java.util.Date;

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/17 20:10
 */
class TimeStamped extends Decorator{

    private final long timeStamp;
    public TimeStamped(Basic basic) { //有参构造，调用父类构造器
        super(basic);
        timeStamp = new Date().getTime();
    }

    public long getStamp() {
        return timeStamp;
    }

}
