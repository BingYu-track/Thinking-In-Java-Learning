package generics.mix.decorator;

import java.awt.*;

/**
 * @Description: 通过装饰器模式达到混型(有待理解)
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
    /*
        装饰器提供了比继承更加富有弹性的代替方案。多用组合，少用继承。不用在程序还未运行时候创建大量类，而是在程序运行中按需动态组合类。扩展性好
    */
}
