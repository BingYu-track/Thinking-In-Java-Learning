package typeinfo;

import java.util.Random;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/28 22:39
 */
public class ClassInitialization {

    public static Random rand = new Random(47);
    public static void main(String[] args) throws Exception {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        // 不触发静态初始化，因为Initable.staticFinal是一个编译时常量
        System.out.println(Initable.staticFinal);
        // 触发静态初始化,因为Initable.staticFinal2是一个运行时常量
        System.out.println(Initable.staticFinal2);
        // 触发静态初始化
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("typeinfo.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}
