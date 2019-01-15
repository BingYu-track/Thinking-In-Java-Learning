//: net/mindview/util/Generated.java
package net.mindview.util;
import org.junit.Test;

import java.util.*;

public class Generated {
  // Fill an existing array: 接受已有的空数组a和Generator，通过new CollectionData<T>(gen, a.length)创建了List后然后填充a,Generator代表填充策略
  public static <T> T[] array(T[] a, Generator<T> gen) {
    return new CollectionData<T>(gen, a.length).toArray(a); //toArray(T[] a) 这里a主要是确定返回时数组的类型
  }
  // Create a new array:
  @SuppressWarnings("unchecked")
  public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
    T[] a = (T[])java.lang.reflect.Array.newInstance(type, size); //使用反射产生一个指定类型，指定大小的空数组
    return new CollectionData<T>(gen, size).toArray(a); //再按照方法1那样向数组填充数据
  }

  @Test
  public void test1(){
    Integer[] a = new Integer[5];
    //创建int生成器对象
    CountingGenerator.Integer generator = new CountingGenerator.Integer();
    Integer[] array = Generated.array(a, generator);
    System.out.println(array);
  }
} ///:~
