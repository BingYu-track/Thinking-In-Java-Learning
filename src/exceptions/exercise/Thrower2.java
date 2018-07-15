package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/10 8:09
 */
class Thrower2 {

    void f() throws Ex1, Ex2, Ex3 {
        throw new Ex1();

    }
}
