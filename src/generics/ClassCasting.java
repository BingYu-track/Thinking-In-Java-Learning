package generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/11 22:22
 */
public class ClassCasting {

    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
        // Won’t Compile:
        // List<Widget> lw1 = List<Widget>.class.cast(in.readObject()); //cast()方法--将一个对象强制转换成此 Class 对象所表示的类或接口
        List<Widget> lw2 = List.class.cast(in.readObject());
    }
}
