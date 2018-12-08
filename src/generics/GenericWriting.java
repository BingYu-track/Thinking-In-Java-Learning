package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description: 泛型写操作
 * @author: hxw
 * @date: 2018/12/8 21:15
 */
public class GenericWriting {

    static <T> T writeExact(List<T> list, T item) {
        list.add(item);
        return item;
    }
    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruit = new ArrayList<Fruit>();
    static void f1() {
        Apple apple = writeExact(apples, new Apple());
        Fruit f = writeExact(GenericWriting.fruit, new Apple());// Error:  List<Fruit> 无法转化成List<Apple>
        //Fruit fruit1 = GenericWriting.<Apple>writeExact(fruit, new Apple());//显示指定静态泛型方法中的泛型
// Incompatible types: found Fruit, required Apple


    }

    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }

    static void f2() {
        writeWithWildcard(apples, new Apple()); //这里T为Apple
        writeWithWildcard(fruit, new Apple()); //这里T为Fruit <? super Fruit> 明显可以添加Apple
    }

    public static void main(String[] args) {
        f1(); f2();
    }
}
