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

    //注意：该方法并不是泛型方法，只是使用了带泛型的参数
    static void f(Map<Person, List<? extends Pet>> petPeople) {

    }
    public static void main(String[] args) {
        f(New.map()); //在jdk1.7之前这样使用时用编译器会报错： f(java.util.Map<typeinfo.pets.Person,java.util.List<? extends typeinfo.pets.Pet>>)
        // in LimitsOfInference cannot be applied to (java.util.Map<java.lang.Object,java.lang.Object>)
        //由此可见调用map()泛型方法后其返回值的泛型其实是被赋给了一个Object类型的变量。但是在jdk1.8之后类型推断有很大提升，这样做是没问题的。
        //因为jdk1.7之前类型推断只对赋值操作有效;
    }
}
