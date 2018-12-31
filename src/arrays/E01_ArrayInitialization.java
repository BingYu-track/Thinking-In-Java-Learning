package arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/31 16:20
 */
public class E01_ArrayInitialization {

    static void hide(BerylliumSphere[] s) {
        System.out.println("Hiding " + s.length + " sphere(s)");
    }

    public static void main(String[] args) {
        // Dynamic aggregate initialization: 动态聚集初始化
        hide(new BerylliumSphere[]{ new BerylliumSphere(), new BerylliumSphere() });
        // The following line produces a compilation error.
        // hide({ new BerylliumSphere() });
        // Aggregate initialization:
        BerylliumSphere[] d = { new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere() };
        hide(d);
        // Dynamic aggregate initialization is redundant in the next case:
        BerylliumSphere[] a = new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere() };
        hide(a);
    }
}
