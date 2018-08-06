package strings;
import generics.coffee.*;

import java.util.ArrayList;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/6 8:09
 */
public class ArrayListDisplay {
    public static void main(String[] args) {
        ArrayList<Coffee> coffees = new ArrayList<Coffee>();
        for(Coffee c : new CoffeeGenerator(10)){ //这里CoffeeGenerator实现了Iterable接口
            coffees.add(c);
        }
        System.out.println(coffees);
    }
}
