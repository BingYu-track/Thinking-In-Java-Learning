package generics;

import typeinfo.pets.*;

/**
 * @version 1.0
 * @Description: 泛型可以持有指定类的子类
 * @author: hxw
 * @date: 2018/9/23 20:45
 */
public class E01_PetsHolder {

    public static void main(String[] args) {
        Holder3<Pet> h3 = new Holder3<Pet>(new Mouse("Mickey"));
        System.out.println(h3.get());
        //Mouse is a kind of Pet, so Holder3<Pet> can hold an instance of Mouse.
    }
}
