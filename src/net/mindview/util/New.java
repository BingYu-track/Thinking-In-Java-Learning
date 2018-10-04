//: net/mindview/util/New.java
// Utilities to simplify generic container creation
// by using type argument inference.
package net.mindview.util;
import java.util.*;

/**
* @Description: 使用这个工具类的目的是利用"类型判断"避免重复写参数列表(
   就像避免这种情况：Map<Person, List<? extends Pet>> petPeople =new HashMap<Person, List<? extends Pet>>();)
* @Author:hxw
* @Date:2018/10/4 14:25
*/
public class New {
  public static <K,V> Map<K,V> map() {
    return new HashMap<K,V>();
  }
  public static <T> List<T> list() {
    return new ArrayList<T>();
  }
  public static <T> LinkedList<T> lList() {
    return new LinkedList<T>();
  }
  public static <T> Set<T> set() {
    return new HashSet<T>();
  }	
  public static <T> Queue<T> queue() {
    return new LinkedList<T>();
  }
  // Examples:
  public static void main(String[] args) {
    Map<String, List<String>> sls = New.map();
    List<String> ls = New.list();
    LinkedList<String> lls = New.lList();
    Set<String> ss = New.set();
    Queue<String> qs = New.queue();
  }
} ///:~
