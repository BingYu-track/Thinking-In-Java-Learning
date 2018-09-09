package typeinfo.toys;

import java.lang.reflect.Constructor;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/9 16:30
 */
public class E19_ReflectionToyCreation {
    public static Toy makeToy(String toyName, int IQ) {
        try {
            Class<?> tClass = Class.forName(toyName);
            for(Constructor<?> ctor : tClass.getConstructors()) {
                Class<?>[] params = ctor.getParameterTypes(); //返回一组Class对象，这些对象表示此Constructor 对象所表示构造方法的形参类型。
                if(params.length == 1){
                    if(params[0] == int.class){
                        return (Toy)ctor.newInstance(new Object[]{ Integer.valueOf(IQ) } ); //使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例
                    }
                }
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static void main(String args[]) {
        System.out.println(makeToy("typeinfo.toys.SuperToy", 150));
    }
}
