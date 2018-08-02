package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/2 8:38
 */
class B extends A{

    public void f() throws Level2Exception {
        throw new Level2Exception();
    }
}
