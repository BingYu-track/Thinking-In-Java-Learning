package enumerated;
import net.mindview.util.*;
/**
 * @version 1.0
 * @Description: 枚举中直接嵌套枚举
 * @author: bingyu
 * @date: 2021/6/23
 */
public enum SecurityCategory {

    STOCK(Security.Stock.class), BOND(Security.Bond.class);
    Security[] values;

    SecurityCategory(Class<? extends Security> kind) {
        values = kind.getEnumConstants();
    }

    interface Security { //Security接口的作用就是将其所包含的enum组合成一个公共类型，然后SecurityCategory才能将Security中的enum作为其构造器的参数使用
        enum Stock implements Security { SHORT, LONG, MARGIN }
        enum Bond implements Security { MUNICIPAL, JUNK }
    }

    public Security randomSelection() { //枚举实例中再随机选取一个里面的枚举实例
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            SecurityCategory category = Enums.random(SecurityCategory.class); //随机选取一个枚举实例
            System.out.println(category + ": " + category.randomSelection());
        }
    }

}
