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

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/16 14:45
 */
public class OrdinaryArguments {

    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedSetter ds = new DerivedSetter(); //DerivedSetter继承了OrdinarySetter方法，因此拥有方法void set(Base base)
        ds.set(derived);
        ds.set(base); //重载方法 Compiles: overloaded, not overridden!
    }
}
