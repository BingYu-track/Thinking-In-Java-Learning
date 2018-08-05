package strings;

import java.util.Random;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/5 22:24
 */
public class UsingStringBuilder {
    public static Random rand = new Random(47);
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for(int i = 0; i < 25; i++) {
            result.append(rand.nextInt(100));
            result.append(", ");
        }
        //删除最后一个逗号和空格(删除倒数两个字符)
        result.delete(result.length()-2, result.length());
        result.append("]");
        return result.toString();
    }
    public static void main(String[] args) {
        UsingStringBuilder usb = new UsingStringBuilder();
        System.out.println(usb);
    }
}
