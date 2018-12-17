/**
 * Project: MyTest
 * <p>
 * File Created at 2018/12/17
 * <p>
 * Copyright 2018 e-dewin.com Corporation Limited.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * dewin Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with e-dewin.com.
 */
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
