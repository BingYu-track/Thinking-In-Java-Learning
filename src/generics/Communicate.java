package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/23 19:42
 */
class Communicate {
    public static <T extends Performs> void perform(T performer) { //需要在边界中指定
        performer.speak();
        performer.sit();
    }
}
