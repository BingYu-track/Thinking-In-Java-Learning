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
 * @date: 2018/12/16 21:01
 */
class Processor1 implements Processor<String,Failure1_1,Failure1_2>{

    static Random rnd = new Random(47);
    static int count = 3;
    public void process(List<String> resultCollector) throws Failure1_1, Failure1_2 {
        if(count-- > 1){
            resultCollector.add("Hep!");
        }else{
            resultCollector.add("Ho!");
        }
        if(count < 0){
            if(rnd.nextBoolean()){
                throw new Failure1_1();
            }
        }
        throw new Failure1_2();
    }
}
