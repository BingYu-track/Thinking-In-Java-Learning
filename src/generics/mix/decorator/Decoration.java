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

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/17 20:13
 */
public class Decoration {

    public static void main(String[] args) {
        TimeStamped t = new TimeStamped(new Basic());
        TimeStamped t2 = new TimeStamped(new SerialNumbered(new Basic()));
        //! t2.getSerialNumber(); // Not available
        SerialNumbered s = new SerialNumbered(new Basic());
        SerialNumbered s2 = new SerialNumbered(new TimeStamped(new Basic()));
        //! s2.getStamp(); // Not available
    }
}
