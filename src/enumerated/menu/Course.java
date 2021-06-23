package enumerated.menu;
import net.mindview.util.*;
/**
 * @version 1.0
 * @Description: 创建枚举的枚举
 * @author: bingyu
 * @date: 2021/6/23
 */
public enum Course {
    APPETIZER(Food.Appetizer.class),  //这个可以看作new枚举实例的操作，声明调用下面Course(Class<? extends Food> kind)这个构造器，两者参数都必须一致
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values; //这个是每个枚举实例存储的它自己下面的枚举实例
    private Course(Class<? extends Food> kind) { //一旦加载枚举Course时，就会将枚举实例一个一个传入构造器中
        values = kind.getEnumConstants();
        System.out.println(values);
    }
    public Food randomSelection() {
        return Enums.random(values);
    }
}
