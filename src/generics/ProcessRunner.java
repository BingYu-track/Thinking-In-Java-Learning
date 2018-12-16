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

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/16 16:54
 */
class ProcessRunner<T,E extends Exception> extends ArrayList<Processor<T,E>> { //这里ArrayList<Processor<T,E>>中T,E泛型在ProcessRunner类中泛型E已经声明继承了Exception

    List<T> processAll() throws E { //注意如果要抛出泛型异常E，该泛型必须声明上界通配符 <E extends Exception>,否则E擦除成为Object很明显不是Throwable的子类
        List<T> resultCollector = new ArrayList<T>();
        for(Processor<T,E> processor : this)
            processor.process(resultCollector);
        return resultCollector;
    }
}
