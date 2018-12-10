package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description: 泛型的公共父类
 * @author: hxw
 * @date: 2018/12/9 22:47
 */
public class CommonFatherTest {

    public static <T> T test1(List<? extends T> a, T b){
        return b;
    }

    public static <T> T test2( T a, T b){
        return b;
    }

    public static void main(String[] args){
        Double d = new Double(2);
        List<?> list = new ArrayList<>();
        List list1 = new ArrayList<>();

        Object o = test1(list, d); //通配符作为Object处理，d是Double类型，为了使两者泛型的类型保持一致，泛型统一为Object
        Double aDouble = test1(list1, d);
        Number number = test2(1, d); //同理，int和Double公共父类为Number
    }
}
