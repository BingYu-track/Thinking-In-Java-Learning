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
 * @Description: 泛型类不能继承Throwable
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/16 20:12
 */
public class MyException<E> extends Exception{ //complier error: Generic class may not extend 'java.lang.Throwable'
}
