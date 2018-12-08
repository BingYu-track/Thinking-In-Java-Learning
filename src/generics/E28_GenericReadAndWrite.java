package generics;

import typeinfo.pets.Cat;
import typeinfo.pets.Pet;
import typeinfo.pets.Rodent;
import typeinfo.pets.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/8 22:53
 */
public class E28_GenericReadAndWrite {

    static <T> void f1(Generic1<? super T> obj, T item) {
        obj.set(item);
    }
    static <T> T f2(Generic2<? extends T> obj) {
        return obj.get();
    }

    public static void main(String[] args) {
        Generic1<Rodent> g1 = new Generic1<Rodent>();
        f1(g1, new Mouse()); // OK
        //f1(g1, new Cat()); // Compile error: Cat is not a Rodent
        Generic2<Pet> g2 = new Generic2<Pet>();
        Pet pet = f2(g2); // OK f2(Generic2<? extends Pet> obj)
        Generic2<Cat> g3 = new Generic2<Cat>();
        Cat cat = f2(g3); // OK
        pet = f2(g3); // OK

        Generic1<Mouse> g4 = new Generic1<Mouse>();
        //f1(g4,new Rodent()); //编译错误 此时f1的泛型是Generic1<? super Mouse>,不能添加用Mouse类型的形参来接受其父类Rodent的实参
    }
}
