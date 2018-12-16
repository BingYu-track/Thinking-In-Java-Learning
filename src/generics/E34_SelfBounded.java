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
 * @date: 2018/12/16 15:56
 */
public class E34_SelfBounded {

    public static void main(String[] args) {
        ConcreteProcessor cp = new ConcreteProcessor();
        System.out.println(cp == cp.test());
    }
}
