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
 * @date: 2018/12/16 15:19
 */
public class SelfBoundingAndCovariantArguments {

    void testA(Setter s1, Setter s2, SelfBoundSetter sbs) {
        s1.set(s2);
        //s1.set(sbs); // Error: set(Setter) in SelfBoundSetter<Setter> cannot be applied to (SelfBoundSetter)
    }
}
