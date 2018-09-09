package typeinfo;


import java.lang.reflect.*;
import java.util.regex.Pattern;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description: 查看类的所有公共方法工具类
 * @author: hxw
 * @date: 2018/9/6 8:19
 */
public class ShowMethods {

    private static String usage = "usage:\n" +
            "ShowMethods qualified.class.name\n" +
            "To show all methods in class or:\n" +
            "ShowMethods qualified.class.name word\n" +
            "To search for methods involving 'word'";
    private static Pattern p = Pattern.compile("\\w+\\."); //这里因为.在正则具有特殊含义，因此需要用反斜杆\\转义

    public static void main(String[] args) {
        args = new String[]{"typeinfo.ShowMethods"};
        if(args.length < 1) {
            print(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]); //此时我们完全不知道args[0]的内容是什么；只有在运行的时候动态传进去
            Method[] methods = c.getMethods();  //返回该类的所有public修饰的方法(包括从父类继承来的)
            Constructor[] ctors = c.getConstructors(); //返回所有public修饰的构造器(如果该类没有公共构造方法，或者该类是一个数组类，或者该类反映一个基本类型或 void，则返回一个长度为 0 的数组)
            if(args.length == 1) {
                for(Method method : methods)
                    print(p.matcher(method.toString()).replaceAll("")); //使用正则去掉命名修饰符
                for(Constructor ctor : ctors){
                    print(p.matcher(ctor.toString()).replaceAll(""));
                }
                lines = methods.length + ctors.length;
            } else {
                for(Method method : methods){
                    if(method.toString().indexOf(args[1]) != -1) { //如果方法在
                        print(p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                }
                for(Constructor ctor : ctors){
                    if(ctor.toString().indexOf(args[1]) != -1) {
                        print(p.matcher(ctor.toString()).replaceAll(""));
                        lines++;
                    }
                }
            }
        } catch(ClassNotFoundException e) {
            print("No such class: " + e);
        }
    }
}
