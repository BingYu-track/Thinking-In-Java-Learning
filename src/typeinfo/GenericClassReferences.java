package typeinfo;

import org.junit.Test;

/**
 * @version 1.0
 * @Description: 泛化Class引用
 * @author: hxw
 * @date: 2018/8/29 8:01
 */
public class GenericClassReferences {

    public static void main(String[] args) {
        Class intClass = int.class; //普通Class的引用intClass
        Class<Integer> genericIntClass = int.class; //泛型Class的引用genericIntClass
        genericIntClass = Integer.class; // Same thing
        intClass = double.class; //普通Class的引用intClass可以指向任何其他类型的Class对象
        // genericIntClass = double.class; // Illegal 而使用泛型语法的Class会让编译器强制进行类型检查
    }

    /**
     * 1.如果需要放松对类型检查的限制可以使用通配符"?"
     */
    @Test
    public void test(){
        Class<?> intClass = int.class;
        intClass = double.class; //带通配符的Class引用，同样可以指向任何其他类型的Class对象
    }
    /*
        问：既然普通Class和Class<?>效果是一样的为什么还要Class<?>？

        答：普通Class和Class<?>两者效果是等价的，但是Class<?>更优于普通Class，因为Class<?>不会产生编译器警告信息，它的含义也表示
            你使用了一个非具体类型的Class引用，这样做更规范。
    */

    /**
     * 2.如果需要将Class的引用指定为某种类型或其子类型，需要将通配符"?"和"extends"关键字结合起来使用类创建一个范围
     */
    @Test
    public void test1(){
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
        // 此例中任何从Number类继承的类的Class引用都可以使用bounded接收
    }
}
