package typeinfo.toys;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/26 22:18
 */
public class ToyTest {
    static void printInfo(Class cc) {
        print("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        print("Simple name: " + cc.getSimpleName());
        print("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args){
        Class c = null;
        try {
            c = Class.forName("typeinfo.toys.FancyToy"); //获取FancyToy的类型信息对象(Class对象)，注意必须使用全限定性类名
        } catch(ClassNotFoundException e) {
            print("Can’t find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for(Class face : c.getInterfaces())  //c.getInterfaces()获取当前类实现的接口集合
            printInfo(face);
        Class up = c.getSuperclass();  //获取直接父类的Class对象
        Object obj = null;
        try {
        // Requires default constructor:
            obj = up.newInstance();
        } catch(InstantiationException e) {
            print("Cannot instantiate");
            System.exit(1);
        } catch(IllegalAccessException e) {
            print("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
