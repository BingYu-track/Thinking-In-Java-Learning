package generics;

import generics.coffee.Coffee;
import generics.coffee.Latte;
import generics.coffee.Mocha;

import java.util.ArrayList;
import java.util.List;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/24 8:03
 */
class Fill2Test {

    public static void main(String[] args) {
        // Adapt a Collection:
        List<Coffee> carrier = new ArrayList<Coffee>();
        Fill2.fill(new AddableCollectionAdapter<Coffee>(carrier), Coffee.class, 3);
        // Helper method captures the type:
        Fill2.fill(Adapter.collectionAdapter(carrier), Latte.class, 2);
        for(Coffee c: carrier){
            print(c);
        }
        print("----------------------");

        // Use an adapted class:
        AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<Coffee>();
        Fill2.fill(coffeeQueue, Mocha.class, 4);
        Fill2.fill(coffeeQueue, Latte.class, 1);
        for(Coffee c: coffeeQueue){
            print(c);
        }
    }
}
