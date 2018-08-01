package exceptions;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/1 8:26
 */
class NeedsCleanup { // Construction can’t fail
    private static long counter = 1;
    private final long id = counter++; //final变量初始化后就无法再次赋值
    public void dispose() {
        System.out.println("NeedsCleanup " + id + " disposed");
    }
}
