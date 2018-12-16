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

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/16 21:05
 */
public class E36_GenericExceptions {

    public static void main(String[] args){
        ProcessRunner<String,Failure1_1,Failure1_2> runner = new ProcessRunner<String,Failure1_1,Failure1_2>();
        for(int i = 0; i < 3; i++){
            runner.add(new Processor1());
        }

        try {
            System.out.println(runner.processAll());
        } catch(Failure1_1 e) {
            System.out.println(e);
        } catch(Failure1_2 e) {
            System.out.println(e);
        }

        ProcessRunner<Integer,Failure2_1,Failure2_2> runner2 = new ProcessRunner<Integer,Failure2_1,Failure2_2>();
        for(int i = 0; i < 3; i++){
            runner2.add(new Processor2());
        }

        try {
            System.out.println(runner2.processAll());
        } catch(Failure2_1 e) {
            System.out.println(e);
        } catch(Failure2_2 e) {
            System.out.println(e);
        }

    }
}
