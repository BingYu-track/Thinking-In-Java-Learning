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

import java.text.ParseException;

/**
 * @Description: 泛型异常
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/16 16:59
 */
public class ThrowGenericException {

    public static void main(String[] args) {
        ProcessRunner<String,Failure1> runner = new ProcessRunner<String, Failure1>();
        for(int i = 0; i < 3; i++){
            runner.add(new Processor1()); //注意因为ProcessRunner<T,E extends Exception> 继承了ArrayList<Processor<T,E>>，因此这里runner只能添加Processor<T,E>类型的对象
        }
        try {
            System.out.println(runner.processAll());//这里runner.processAll()抛出的异常就是来自泛型E，这里异常会随着泛型类ProcessRunner E的改变而改变
        } catch(Failure1 e) {
            System.out.println(e);
        }
        ProcessRunner<Integer,Failure2> runner2 = new ProcessRunner<Integer,Failure2>();
        for(int i = 0; i < 3; i++){
            runner2.add(new Processor2());
        }
        try {
            System.out.println(runner2.processAll());
        } catch(Failure2 e) {
            System.out.println(e);
        }

    }
}
