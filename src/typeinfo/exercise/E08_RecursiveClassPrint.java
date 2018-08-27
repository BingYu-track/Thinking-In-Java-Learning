package typeinfo.exercise;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description: 递归打印对象所在继承体系的所有类
 * @author: hxw
 * @date: 2018/8/27 23:11
 */
public class E08_RecursiveClassPrint {

    static void printClasses(Class<?> c) {
        // getSuperclass() returns null on Object:
        if(c == null) return;
        print(c.getName());
        // Produces the interfaces that this class implements: 生成该类实现的接口：
        for(Class<?> k : c.getInterfaces()) {
            print("Interface: " + k.getName());
            printClasses(k.getSuperclass()); //递归调用获取接口
        }
        printClasses(c.getSuperclass()); //递归调用获取父类
    }

    public static void main(String[] args) throws Exception {
        args = new String[]{"typeinfo.Circle","typeinfo.toys.FancyToy"};
        for(int i = 0; i < args.length; i++) {
            print("Displaying " + args[i]);
            printClasses(Class.forName(args[i]));
            if(i < args.length - 1)
                System.out.println("==================");
        }
    }
}
