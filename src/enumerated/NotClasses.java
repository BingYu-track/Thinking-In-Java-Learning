package enumerated;
import static net.mindview.util.Print.*;

enum LikeClasses {
    WINKEN { void behavior() { print("Behavior1"); } },
    BLINKEN { void behavior() { print("Behavior2"); } },
    NOD { void behavior() { print("Behavior3"); }

        @Override
        void habit() { //枚举实例也可以覆盖普通方法，这个不是强制性的
            System.out.println();
        }
    };
    abstract void behavior();
    void habit() {};
}
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/24
 */
public class NotClasses {

    //编译器不允许将一个enum实例当作class类型,因此enum的实例不能作为参数的类型
    // 因为每个LikeClasses的enum元素都是一个LikeClasses类型的static final实例(通过javap反编译.class文件知道)
    //而不是类，实例对象当然不能作为类了!
    //void f1(LikeClasses.WINKEN instance) {} // Nope

    //反编译得到如下:LikeClasses变为了abstract类了，我们知道枚举中如果定义了abstract方法，枚举类型就是抽象类，否则就是普通的类
    /*
    Compiled from "NotClasses.java"
    abstract class enumerated.LikeClasses extends java.lang.Enum<enumerated.LikeClasses> {
      public static final enumerated.LikeClasses WINKEN;
      public static final enumerated.LikeClasses BLINKEN;
      public static final enumerated.LikeClasses NOD;
      public static enumerated.LikeClasses[] values();
      public static enumerated.LikeClasses valueOf(java.lang.String);
      abstract void behavior();
      void habit();
      enumerated.LikeClasses(java.lang.String, int, enumerated.LikeClasses$1);
      static {};
    }
     */

    void f2(LikeClasses instance) {

    }

}
