//: net/mindview/util/TypeCounter.java
// Counts instances of a type family.
package net.mindview.util;
import java.util.*;

/**
* @Description: 递归计数器
* @Author:hxw
* @Date:2018/9/3 22:02
*/
public class TypeCounter extends HashMap<Class<?>,Integer>{
  private Class<?> baseType;
  public TypeCounter(Class<?> baseType) {
    this.baseType = baseType;
  }

  public void count(Object obj) {
    Class<?> type = obj.getClass();
    if(!baseType.isAssignableFrom(type)){ //如果baseType不是type所表示的类或超类
      throw new RuntimeException(obj + " incorrect type: "
              + type + ", should be type or subtype of "
              + baseType);
    }
    countClass(type); //为type所表示的类计数
  }	
  private void countClass(Class<?> type) {
    Integer quantity = get(type);
    put(type, quantity == null ? 1 : quantity + 1);
    Class<?> superClass = type.getSuperclass();
    if(superClass != null && baseType.isAssignableFrom(superClass)){ //如果type有父类，并且该父类的超类是baseType所表示的类
      countClass(superClass); //继续对该父类计数
    }
  }
  public String toString() {
    StringBuilder result = new StringBuilder("{");
    for(Entry<Class<?>,Integer> pair : entrySet()) {
      result.append(pair.getKey().getSimpleName());
      result.append("=");
      result.append(pair.getValue());
      result.append(", ");
    }
    result.delete(result.length()-2, result.length());
    result.append("}");
    return result.toString();
  }
} ///:~
