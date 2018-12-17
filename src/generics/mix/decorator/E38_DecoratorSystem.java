package generics.mix.decorator;

import java.awt.*;

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/17 21:27
 */
public class E38_DecoratorSystem {

    public static void main(String[] args) {
        CoffeeDecorator cappuccino = new Foam(new SteamedMilk(new BasicCoffee("espresso")));
        System.out.println("Capuccino is: " + cappuccino.getType());
        CoffeeDecorator whiteChocolateCoffee = new WhippedCream(new Chocolate(new BasicCoffee("hot coffee"), Color.WHITE));
        System.out.println("White Chocolate Coffee is: " + whiteChocolateCoffee.getType());
    }
}
