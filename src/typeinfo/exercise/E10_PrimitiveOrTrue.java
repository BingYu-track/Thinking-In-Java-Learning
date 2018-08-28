package typeinfo.exercise;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/28 21:45
 */
public class E10_PrimitiveOrTrue {

    public static void main(String[] args){
        char[] ac = "Hello, World!".toCharArray();
        print("ac.getClass() = " + ac.getClass()); //ac.getClass() = class [C
        print("ac.getClass().getSuperclass() = " + ac.getClass().getSuperclass()); //ac.getClass().getSuperclass() = class java.lang.Object
        char c = 'c';
        //! c.getClass(); // 不能这样做，因为c是一个基本类型，只有Object类型的才能使用getClass()
        int[] ia = new int[3];
        print("ia.getClass() = " + ia.getClass()); //ia.getClass() = class [I
        long[] la = new long[3];
        print("la.getClass() = " + la.getClass()); //la.getClass() = class [J
        double[] da = new double[3];
        print("da.getClass() = " + da.getClass()); //da.getClass() = class [D
        String[] sa = new String[3];
        print("sa.getClass() = " + sa.getClass()); //sa.getClass() = class [Ljava.lang.String;
        E10_PrimitiveOrTrue[] pot = new E10_PrimitiveOrTrue[3];
        print("pot.getClass() = " + pot.getClass()); //pot.getClass() = class [Ltypeinfo.exercise.E10_PrimitiveOrTrue;
        // 多维数组:
        int[][][] threed = new int[3][][];
        print("threed.getClass() = " + threed.getClass()); //threed.getClass() = class [[[I

        /**
         * 所有数组类名都以‘[’开头，后面跟着一个基本类型的字符代码，而L后面跟着数组中包含的对象数组的元素类型。多维数组为每个维度添加一个“[”
         */
    }
}
