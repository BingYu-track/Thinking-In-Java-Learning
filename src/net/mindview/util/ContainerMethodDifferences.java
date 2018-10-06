//: net/mindview/util/ContainerMethodDifferences.java
package net.mindview.util;
import java.lang.reflect.*;
import java.util.*;

public class ContainerMethodDifferences {

  static Set<String> object = methodSet(Object.class);

  static {
    object.add("clone");
  }

  //获取类的所有公共方法集合
  static Set<String> methodSet(Class<?> type) {
    Set<String> result = new TreeSet<String>();
    for(Method m : type.getMethods())
      result.add(m.getName());
    return result;
  }

  //获取该类实现的所有接口
  static void interfaces(Class<?> type) {
      System.out.print("Interfaces in " + type.getSimpleName() + ": ");
      List<String> result = new ArrayList<String>();
      for(Class<?> c : type.getInterfaces())
        result.add(c.getSimpleName());
      System.out.println(result);
  }

  /**
   * 计算父类和子类之间的差集
   * @param superset 父类
   * @param subset 子类
   */
  static void difference(Class<?> superset, Class<?> subset) {
      System.out.print(superset.getSimpleName() + " extends " + subset.getSimpleName() + ", adds: ");
      Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
      comp.removeAll(object); // Don't show 'Object' methods
      System.out.println(comp);
      interfaces(superset);
  }
  public static void main(String[] args) {
    System.out.println("Collection: " + methodSet(Collection.class));
    interfaces(Collection.class);
    difference(Set.class, Collection.class);
    difference(HashSet.class, Set.class);
    difference(LinkedHashSet.class, HashSet.class);
    difference(TreeSet.class, Set.class);
    difference(List.class, Collection.class);
    difference(ArrayList.class, List.class);
    difference(LinkedList.class, List.class);
    difference(Queue.class, Collection.class);
    difference(PriorityQueue.class, Queue.class);
    System.out.println("Map: " + methodSet(Map.class));
    difference(HashMap.class, Map.class);
    difference(LinkedHashMap.class, HashMap.class);
    difference(SortedMap.class, Map.class);
    difference(TreeMap.class, Map.class);
  }
} ///:~
