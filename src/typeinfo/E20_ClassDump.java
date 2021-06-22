package typeinfo;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/9 16:43
 */
public class E20_ClassDump {
    public static void display(String msg, Object[] vals) {
        print(msg);
        for(Object val : vals)
            print(" " + val);
    }

   public class Test{}

    public static void classInfo(Class<?> c) throws Exception {
        print("c.getName(): " + c.getName());
        print("c.getPackage(): " + c.getPackage());
        print("c.getSuperclass(): " + c.getSuperclass());
        // 这将生成声明为成员的所有类。
        display("c.getDeclaredClasses()", c.getDeclaredClasses()); //返回类中定义的公共、私有、保护的内部类
        display("c.getClasses()", c.getClasses()); //只返回类定义的公共的内部类,以及从父类、父接口那里继承来的内部类(只返回公共的内部类)
        display("c.getInterfaces()", c.getInterfaces()); //
        display("c.getGenericInterfaces()",c.getGenericInterfaces()); //
        // The "Declared" version includes all versions, not just public:
        display("c.getDeclaredMethods()", c.getDeclaredMethods()); //返回公共、保护、默认（包）访问和私有方法，但不包括继承的方法
        display("c.getMethods()", c.getMethods()); //只返回所有公共的方法，但包括从父类继承的方法
        display("c.getDeclaredConstructors()", c.getDeclaredConstructors());
        display("c.getConstructors()", c.getConstructors());
        display("c.getDeclaredFields()", c.getDeclaredFields());
        display("c.getFields()", c.getFields());
        if(c.getSuperclass() != null) {
            print("Base class: --------");
            classInfo(c.getSuperclass());
        }
        print("End of " + c.getName());
    }
    public static void main(String[] args) throws Exception {
        args = new String[]{"typeinfo.E20_ClassDump"};
        for(String arg : args)
            classInfo(Class.forName(arg));
    }
}
