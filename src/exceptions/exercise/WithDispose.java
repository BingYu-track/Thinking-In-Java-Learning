package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/1 23:36
 */
class WithDispose {
    private final int id;
    WithDispose(int id) { this.id = id; }
    void dispose() {
        System.out.println("WithDispose.dispose(): " + id);
    }
}
