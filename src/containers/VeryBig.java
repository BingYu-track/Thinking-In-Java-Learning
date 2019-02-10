package containers;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/10 16:01
 */
public class VeryBig{

    private static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;
    public VeryBig(String id) {
        ident = id;
    }
    public String toString() {
        return ident;
    }
    protected void finalize() {
        System.out.println("Finalizing " + ident);
    }
}
