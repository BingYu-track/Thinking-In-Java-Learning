package generics;

import net.mindview.util.FourTuple;

import java.util.ArrayList;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/10/6 18:48
 */
public class TupleList<A,B,C,D> extends ArrayList<FourTuple<A,B,C,D>> {

    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> tl = new TupleList<Vehicle, Amphibian, String, Integer>();
        tl.add(TupleTest.h());
        tl.add(TupleTest.h());
        for(FourTuple<Vehicle,Amphibian,String,Integer> i: tl)
            System.out.println(i);
    }
}
