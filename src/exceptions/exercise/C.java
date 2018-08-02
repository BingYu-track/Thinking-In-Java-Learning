package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/2 8:39
 */
class C extends B{
    public void f() throws Level3Exception {
        throw new Level3Exception();
    }
}
