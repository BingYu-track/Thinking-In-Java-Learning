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
package generics.exception;

import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/16 21:03
 */
class Processor2 implements Processor<Integer,Failure2_1,Failure2_2>{

    static Random rnd = new Random(47);
    static int count = 2;
    public void
    process(List<Integer> resultCollector) throws Failure2_1, Failure2_2 {
        if(count-- == 0){
            resultCollector.add(47);
        }else {
            resultCollector.add(11);
        }
        if(count < 0){
            if(rnd.nextBoolean()){
                throw new Failure2_1();
            }
        }
        throw new Failure2_2();
    }
}
