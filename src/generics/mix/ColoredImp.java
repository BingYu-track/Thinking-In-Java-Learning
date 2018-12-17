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
package generics.mix;

import java.awt.*;
import java.util.Random;

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/17 12:45
 */
class ColoredImp implements Colored{
    private static Random rnd = new Random(47);
    private final Color clr = new Color(rnd.nextInt(16777216)); // 2^24
    public Color getColor() {
        return clr;
    }
}
