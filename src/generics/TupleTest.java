package generics;

import net.mindview.util.FiveTuple;
import net.mindview.util.FourTuple;
import net.mindview.util.ThreeTuple;
import net.mindview.util.TwoTuple;

/**
 * @version 1.0
 * @Description: 使用泛型实现元组；元组和列表list一样,都可能用于数据存储包含多个数据,但是和列表不同的是:列表只能存储相同的数据类型,而元组不一样,它可以存储不同的数据类型
 * 比如同时存储int,string,list等;并且可以根据需求无限扩展
 * @author: hxw
 * @date: 2018/9/24 13:45
 */
public class TupleTest {

    static TwoTuple<String,Integer> f() {
        // Autoboxing converts the int to Integer:
        return new TwoTuple<String,Integer>("hi", 47);
    }

    static ThreeTuple<Amphibian,String,Integer> g() {
        return new ThreeTuple<Amphibian, String, Integer>(new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle,Amphibian,String,Integer> h() {
        return new FourTuple<Vehicle,Amphibian,String,Integer>(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static FiveTuple<Vehicle,Amphibian,String,Integer,Double> k() {
        return new FiveTuple<Vehicle,Amphibian,String,Integer,Double>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        TwoTuple<String,Integer> ttsi = f();
        System.out.println(ttsi);
        // ttsi.first = "there"; // Compile error: final
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
