package containers;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/8 3:06
 */
public class E28_Tuple {

    public static void main(String[] args) {
        Tuple.T5<String,Integer,Boolean,Short,Long> t5_1 = Tuple.tuple("a", 1, false, (short)2, 3L),
                t5_2 = Tuple.tuple("b", 2, true, (short)3, 4L);
        print("t5_1 = " + t5_1);
        print("t5_2 = " + t5_2);
        print("t5_1.equals(t5_1) = " + t5_1.equals(t5_1));
        print("t5_1.equals(t5_2) = " + t5_1.equals(t5_2));
        print("t5_1.compareTo(t5_1) = " + t5_1.compareTo(t5_1));
        print("t5_1.compareTo(t5_2) = " + t5_1.compareTo(t5_2));
    }
}
