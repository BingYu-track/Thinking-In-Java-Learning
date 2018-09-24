//: net/mindview/util/Generator.java
// A generic interface.
package net.mindview.util;

/**
* @Description: 泛型接口(与类使用泛型没有区别)
* @Author:hxw
* @Date:2018/9/24 22:30
*/
//一般而言一个生成器只定义一个方法用来产生新的对象
public interface Generator<T> {
    T next();
} ///:~
