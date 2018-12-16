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
 * @date: 2018/12/16 15:41
 */
public class PlainGenericInheritance {

    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedGS dgs = new DerivedGS(); //DerivedGS继承了 GenericSetter<Base>，因此重载了其void set(T arg)方法，但
        // 是，如果GenericSetter<T>泛型改成GenericSetter<T extends GenericSetter<T>>，那么
        dgs.set(derived);
        dgs.set(base); // Compiles: overloaded, not overridden!
    }
}
