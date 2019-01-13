package arrays;

import java.lang.reflect.Field;
import java.util.Arrays;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/13 22:23
 */
public class E18_ArrayCopy {

    // BerylliumSphere.id is private, so we need to use reflection to alter its value.
    //BerylliumSphere的id是私有的，所以我们需要使用反射来改变它的值
    static void setID(BerylliumSphere bs, long value) {
        try {
            Field fid = BerylliumSphere.class.getDeclaredField("id");
            fid.setAccessible(true);
            fid.setLong(bs, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BerylliumSphere[] a = new BerylliumSphere[4];
        Arrays.fill(a, new BerylliumSphere()); //注意这里Arrays.fill()对象实际填充的是传进来对象的引用，而不是真正new了个对象
        BerylliumSphere[] b = new BerylliumSphere[4];
        print("a = " + Arrays.toString(a));
        print("b = " + Arrays.toString(b));
        System.arraycopy(a, 0, b, 0, b.length); //
        print("b = " + Arrays.toString(b));
        // Changing a reference in 'a' will not impact 'b'.
        a[1] = a[3] = new BerylliumSphere();
        print("a = " + Arrays.toString(a));//a = [Sphere 0, Sphere 1, Sphere 0, Sphere 1]
        print("b = " + Arrays.toString(b)); //b = [Sphere 0, Sphere 0, Sphere 0, Sphere 0]
        // Changing an object's state will impact 'b', as well.
        setID(a[0], -1L);
        print("a = " + Arrays.toString(a)); //a = [Sphere -1, Sphere 1, Sphere -1, Sphere 1]
        print("b = " + Arrays.toString(b)); //b = [Sphere -1, Sphere -1, Sphere -1, Sphere -1]
        //由于System.arraycopy复制的也是对象的引用，因此改变a数组中的第一个元素的id，从而导致b数组所有元素的id改变
    }
}
