package typeinfo.exercise;

import java.lang.reflect.*;
import java.util.*;
import static net.mindview.util.Print.*;

/**
 * @version 1.0
 * @Description: 递归打印对象内的所有成员信息
 * @author: hxw
 * @date: 2018/8/27 23:26
 */
public class E09_GetDeclaredFields {

    static Set<Class<?>> alreadyDisplayed = new HashSet<Class<?>>();

    static void printClasses(Class<?> c) {
        // getSuperclass() returns null on Object:
        if(c == null) return;
        print(c.getName());
        Field[] fields = c.getDeclaredFields(); //返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段
        if(fields.length != 0) print("Fields:");

        for(Field fld : fields) {
            print(" " + fld);
        }
        for(Field fld : fields) {
            Class<?> k = fld.getType();
            if(!alreadyDisplayed.contains(k)) {
                printClasses(k);
                alreadyDisplayed.add(k);
            }
        }
        // Produces the interfaces that this class
        // implements:
        for(Class<?> k : c.getInterfaces()) {
            print("Interface: " + k.getName());
            printClasses(k.getSuperclass());
        }
        printClasses(c.getSuperclass());
    }

    public static void main(String[] args) throws Exception{
        args = new String[]{"typeinfo.exercise.Derived"};
        for(int i = 0; i < args.length; i++) {
            print("Displaying " + args[i]);
            printClasses(Class.forName(args[i]));
            if(i < args.length - 1)
                System.out.println("==================");
        }
    }
}
