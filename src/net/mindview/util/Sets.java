//: net/mindview/util/Sets.java
package net.mindview.util;
import java.util.*;

/**
* @Description: Set工具类，用来表示集合之间的计算
* @Author:hxw
* @Date:2018/10/6 11:25
*/
public class Sets {

  /**
   * 求a、b两个集合的并集
   * @param a 集合a
   * @param b 集合b
   * @param <T> 类型参数
   * @return
   */
  public static <T> Set<T> union(Set<T> a, Set<T> b) {
    Set<T> result = new HashSet<T>(a);
    result.addAll(b);
    return result;
  }

  /**
   * 求a、b两个集合的交集
   * @param a 集合a
   * @param b 集合b
   * @param <T> 类型参数
   * @return
   */
  public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
    Set<T> result = new HashSet<T>(a);
    result.retainAll(b);
    return result;
  }

  /**
   * 从超集减去子集
   * @param superset 超集
   * @param subset 子集
   * @param <T> 类型参数
   * @return
   */
  public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
    Set<T> result = new HashSet<T>(superset);
    result.removeAll(subset);
    return result;
  }

  /**
   * 求两个集合的补集(即交集之外的所有元素)
   * @param a 集合a
   * @param b 集合b
   * @param <T> 类型参数
   * @return
   */
  public static <T> Set<T> complement(Set<T> a, Set<T> b) {
    return difference(union(a, b), intersection(a, b));
  }

} ///:~
