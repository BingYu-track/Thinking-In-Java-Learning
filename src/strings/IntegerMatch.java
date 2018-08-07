package strings;

/**
 * @version 1.0
 * @Description: 正则表达式
 * @author: hxw
 * @date: 2018/8/7 22:14
 */
public class IntegerMatch {
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        //这里括号是将表达式分组，竖直线|表示或，由于+在正则表达式有特殊意义，所以需要使用\\进行转义为普通的+
        System.out.println("+911".matches("(-|\\+)?\\d+"));
    }
}
