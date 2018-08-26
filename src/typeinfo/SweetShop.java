package typeinfo;
import static net.mindview.util.Print.print;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/26 21:04
 */
public class SweetShop {

    public static void main(String[] args) {
        print("inside main");
        new Candy();
        print("After creating Candy");
        try {
            Class.forName("Gum");
        } catch(ClassNotFoundException e) {
            print("Couldn’t find Gum");
        }
        print("After Class.forName(\"Gum\")");
        new Cookie();
        print("After creating Cookie");
    }
    /*根据static的静态语句块可以发现这个类什么时候被加载，会发现Gum类并没有被加载
       结论：Class对象
     */
}
