//: net/mindview/util/BasicGenerator.java
// Automatically create a Generator, given a class
// with a default (no-arg) constructor.
package net.mindview.util;

/**
* @Description: 通用生成器
* @Author:hxw
* @Date:2018/10/5 22:07
*/
public class BasicGenerator<T> implements Generator<T> {
  private Class<T> type;

  //有参构造
  public BasicGenerator(Class<T> type){ this.type = type; }

  public T next() {
    try {
      // Assumes type is a public class:假设type是公共类
      return type.newInstance(); //反射创建对象
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }
  // Produce a Default generator given a type token:生成给定类型令牌的默认生成器
  public static <T> Generator<T> create(Class<T> type) {
    return new BasicGenerator<T>(type);
  }
} ///:~
