package generics;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @Description: 泛型读操作
 * @author: hxw
 * @date: 2018/12/8 22:21
 */
public class GenericReading {
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }
    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruit = Arrays.asList(new Fruit());

    // A static method adapts to each call:
    static void f1() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruit);
        f = readExact(apples);
    }

    // If, however, you have a class, then its type is
    // established when the class is instantiated:
    static class Reader<T> {
        T readExact(List<T> list) { return list.get(0); }
    }

    static void f2() {
        Reader<Fruit> fruitReader = new Reader<Fruit>();
        Fruit f = fruitReader.readExact(fruit);
        // Fruit a = fruitReader.readExact(apples); // 编译报错，无法传入List<Apple>类型
    }
    static class CovariantReader<T> {

        T data;

        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }

        T setCovariant(List<? extends T> list) {
            return data = list.get(0);
        }
    }

    static void f3() {
        CovariantReader<Fruit> fruitReader = new CovariantReader<Fruit>(); //此时readCovariant泛型为 <? extends Fruit>
        Fruit f = fruitReader.readCovariant(fruit);
        Fruit a = fruitReader.readCovariant(apples);
        fruitReader.setCovariant(fruit);
    }

    public static void main(String[] args) {
        f1(); f2(); f3();
    }
}
