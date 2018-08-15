package strings;

import java.util.Formatter;

/**
 * @version 1.0
 * @Description: 格式化说明符
 * @author: hxw
 * @date: 2018/8/6 21:48
 */
public class Receipt {

    private double total = 0;
    private Formatter f = new Formatter(System.out);
    public void printTitle() {
        f.format("%-15s %5s %10s\n", "Item", "Qty", "Price"); //
        f.format("%-15s %5s %10s\n", "----", "---", "-----");
    }
    public void print(String name, int qty, double price) {
        f.format("%-15.15s %5d %10.2f\n", name, qty, price);
        total += price;
    }
    public void printTotal() {
        f.format("%-15s %5s %10.2f\n", "Tax", "", total*0.06);
        f.format("%-15s %5s %10s\n", "", "", "-----");
        f.format("%-15s %5s %10.2f\n", "Total", "", total * 1.06);
    }
    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack’s Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
    /*
    1.常规类型、字符类型和数值类型的格式说明符的语法如下： %[argument_index$][flags][width][.precision]conversion
     可选 argument_index 是一个十进制整数，表示需要将参数列表中第几个参数进行格式化,用$进行间隔。例如第一个参数由 "1$" 引用，第二个参数由 "2$" 引用，依此类推。
     可选 flags 是修改输出格式的字符集。比如‘-’代表向左对齐。
     可选 width 是一个非负十进制整数，表明输出的最小的宽度，适用于所有的参数类型。
     可选 .precision 是一个非负十进制整数(一定要带.)，通常用来限制字符数(指明最大尺寸)。特定行为取决于转换类型。
     所需 conversion 表示接受的参数类型，如s代表后面接String类型的参数；d代表接int型的参数。
        a：参数类型为String时，他表示打印String输出字符的最大数量。
        b：参数类型为浮点数时：表示小数部分要显示出来的位数，如果位数过多则四舍五入，太少则在尾部补零。
        c：参数类型为整数时：会抛出异常，无法应用于整数。

        例如：f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
        这里%-15s中的 '-' 代表[flag]表示向左对齐(不加'-'默认是向右对齐)，15代表[width]，表明该字符串最小长度是15，如果实际
        字符串长度不足，将用空格填充直到15个长度，这里没有[.precision]，s代表conversion，表示是一个字符串类型。\n表示的是"换行"

    2.用来表示日期和时间类型的格式说明符的语法如下： %[argument_index$][flags][width]conversion
    可选的 argument_index、flags 和 width 的定义同上。
    所需的 conversion 是一个由两字符组成的序列。第一个字符是 't' 或 'T'。第二个字符表明所使用的格式。这些字符类似于但不完全等同于那些由 GNU date 和 POSIX strftime(3c) 定义的字符。

    3.与参数不对应的格式说明符的语法如下： %[flags][width]conversion
        可选 flags 和 width 的定义同上。
        所需的 conversion 是一个表明要在输出中所插内容的字符
    */
}
