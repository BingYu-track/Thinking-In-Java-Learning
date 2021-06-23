package enumerated;
import java.lang.reflect.*;
import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;
enum Explore { HERE, THERE }
/**
 * @version 1.0
 * @Description: 为什么Enum.java里没有values()方法，但是我们创建的枚举类都能调用values()这个方法？
 * @author: bingyu
 * @date: 2021/6/21
 */
public class Reflection {

    public static Set<String> analyze(Class<?> enumClass) {
        print("----- Analyzing " + enumClass + " -----");
        print("Interfaces:");
        for(Type t : enumClass.getGenericInterfaces()) {
            print(t);
        }
        print("Base: " + enumClass.getSuperclass());
        print("Methods: ");
        Set<String> methods = new TreeSet<String>();
        for(Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        print(methods);
        return methods;
    }
    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        print("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));
        printnb("Explore.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods);
        print(exploreMethods);
        // Decompile the code for the enum:
        OSExecute.command("javap Explore"); //反编译Explore.class文件
    }

    //输出内容，会发现我们自己创建的枚举类比Enum.java类要多一个values方法，通过使用javap反编译Explore.class文件
    //我们发现values()是由编译器添加的static方法，而且在创建Explore的过程中，编译器还为其添加了valueOf()方法
    //而且我们发现编译器将Explore标记为final类，所以我们是无法继承自enum的
   /* ----- Analyzing class enumerated.Explore -----
    Interfaces:
    Base: class java.lang.Enum
    Methods:
            [compareTo, equals, getClass, getDeclaringClass, hashCode, name, notify, notifyAll, ordinal, toString, valueOf, values, wait]
            ----- Analyzing class java.lang.Enum -----
    Interfaces:
    java.lang.Comparable<E>
    interface java.io.Serializable
    Base: class java.lang.Object
    Methods:
            [compareTo, equals, getClass, getDeclaringClass, hashCode, name, notify, notifyAll, ordinal, toString, valueOf, wait]
            Explore.containsAll(Enum)? true
            Explore.removeAll(Enum):
            [values]

    反编译后的结果：
    Compiled from "Reflection.java"
    final class enumerated.Explore extends java.lang.Enum<enumerated.Explore> {
    public static final enumerated.Explore HERE;
    public static final enumerated.Explore THERE;
    public static enumerated.Explore[] values();
    public static enumerated.Explore valueOf(java.lang.String);
    static {};
}
     */
}
