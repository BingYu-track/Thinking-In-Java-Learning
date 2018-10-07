package generics;

import java.util.*;

/**
 * @version 1.0
 * @Description: 泛型擦除引发的问题
 * @author: hxw
 * @date: 2018/10/7 12:35
 */
public class LostInformation {
    public static void main(String[] args) {
        List<Frob> list = new ArrayList<Frob>();
        Map<Frob,Fnorkle> map = new HashMap<Frob,Fnorkle>();
        Quark<Fnorkle> quark = new Quark<Fnorkle>();
        Particle<Long,Double> p = new Particle<Long,Double>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters())); //getTypeParameters()方法，返回泛型的类型参数(用数组表示)
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
    }
    /*
        根据jdk文档中描述Class.getTypeParameters()将返回一个TypeVariable对象数组，表示有泛型所声明的类型参数，但是从输出看到的
        是只是返回的用作参数占位符的标识符，并不是我们需要的信息。
        因此---"在泛型代码内部，无法获得任何有关泛型参数类型的信息"

        Java泛型是使用擦除实现的，这意外着当使用泛型时，任何具体的类型信息都被擦除。因此List<String>和List<Integer>在运行时事实上
        是相同的类型，这两种形式都被擦除成他们的原生类型，即List
    */
}
