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

import java.util.List;

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/16 16:58
 */
class Processor2 implements Processor<Integer,Failure2>{
    static int count = 2;
    public void process(List<Integer> resultCollector) throws Failure2 {
        if(count-- == 0){
            resultCollector.add(47);
        }else {
            resultCollector.add(11);
        }
        if(count < 0)
            throw new Failure2();
    }
}
