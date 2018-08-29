package typeinfo;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/29 21:24
 */
class CountedInteger {
    private static long counter;
    private final long id = counter++; //每次初始化时，先赋值后自增
    public String toString() {
        return Long.toString(id);
    }
}
