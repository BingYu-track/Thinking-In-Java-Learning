/**
 * Project: MyTest
 * <p>
 * File Created at 2018/12/16
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
package generics;

import generics.coffee.Americano;
import generics.coffee.Breve;
import generics.coffee.Coffee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/16 16:36
 */
public class E35_CheckedList2 {

    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyAmericanos) {
        probablyAmericanos.add(new Breve());
    }
    public static void main(String[] args) {
        List<Americano> am1 = new ArrayList<Americano>();
        oldStyleMethod(am1); // Quietly accepts a Breve
        List<Americano> am2 = Collections.checkedList(new ArrayList<Americano>(), Americano.class);
        try {
            oldStyleMethod(am2); // Throws an exception
        } catch(Exception e) {
            System.out.println(e);
        }
// Derived types work fine:
        List<Coffee> coffees = Collections.checkedList(new ArrayList<Coffee>(), Coffee.class);
        coffees.add(new Americano());
        coffees.add(new Breve());
    }
}
