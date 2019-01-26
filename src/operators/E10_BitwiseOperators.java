package operators;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description: 按位操作符
 * @author: hxw
 * @date: 2019/1/27 0:18
 */
public class E10_BitwiseOperators {

    public static void main(String[] args) {
        int i1 = 0xaaaaaaaa;
        int i2 = 0x55555555;
        print("i1 = " + Integer.toBinaryString(i1));
        print("i2 = " + Integer.toBinaryString(i2));
        print("~i1 = " + Integer.toBinaryString(~i1));
        print("~i2 = " + Integer.toBinaryString(~i2));
        print("i1 & i1 = " + Integer.toBinaryString(i1 & i1));
        print("i1 | i1 = " + Integer.toBinaryString(i1 | i1));
        print("i1 ^ i1 = " + Integer.toBinaryString(i1 ^ i1));
        print("i1 & i2 = " + Integer.toBinaryString(i1 & i2));
        print("i1 | i2 = " + Integer.toBinaryString(i1 | i2));
        print("i1 ^ i2 = " + Integer.toBinaryString(i1 ^ i2));
        //注意：Integer.toBinaryString()无法打印开头的0

        boolean modified = true;
        modified ^= true; //异或，即相同为0，不同为1
        System.out.println(modified);
        int i = 10;
        System.out.println("i: "+Integer.toBinaryString(i));
        System.out.println("2: "+Integer.toBinaryString(2));
        i &= 2;
        System.out.println("1|2 :"+i);
    }
}
