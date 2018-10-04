package generics;

import net.mindview.util.New;
import typeinfo.pets.*;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Description: 显示类型说明解决 generics.LimitsOfInference类中编译器报错的问题，基本很少用知道即可
 * @author: hxw
 * @date: 2018/10/4 21:43
 */
public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {}
    public static void main(String[] args) {
        f(New.<Person, List<Pet>>map());
    }
}
