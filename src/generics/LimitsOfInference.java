package generics;

import net.mindview.util.New;
import typeinfo.pets.*;
import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/10/4 21:10
 */
public class LimitsOfInference {

    static void f(Map<Person, List<? extends Pet>> petPeople) {}
    public static void main(String[] args) {
        f(New.map()); //在jdk1.7之前这样使用时会报错的，因为这时类型推断只对赋值操作有效;调用泛型方法后其返回值其实是被赋给了一个
        //Object类型的变量 Does not compile,但是在jdk1.8之后类型推断有很大提升，这样做是没问题的。
    }
}
