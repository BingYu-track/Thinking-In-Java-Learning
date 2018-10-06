package generics;

import net.mindview.util.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/10/6 10:08
 */
public class TupleTest2 {

    static TwoTuple<String,Integer> f() { //返回的参数化对象
        return Tuple.tuple("hi", 47);
    }
    static TwoTuple f2() {
        return Tuple.tuple("hi", 47);
    }

    static void f3(TwoTuple<String,Integer> w){
        System.out.println(w);
    }

    static ThreeTuple<Amphibian,String,Integer> g() {
        return Tuple.tuple(new Amphibian(), "hi", 47);
    }
    static FourTuple<Vehicle,Amphibian,String,Integer> h() {
        return Tuple.tuple(new Vehicle(), new Amphibian(), "hi", 47);
    }
    static FiveTuple<Vehicle,Amphibian,String,Integer,Double> k() {
        return Tuple.tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        TwoTuple<String,Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
