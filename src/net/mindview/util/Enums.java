//: net/mindview/util/Enums.java
package net.mindview.util;
import java.util.*;

/**
 * Enum随机选取
 */
public class Enums {
  private static Random rand = new Random(47);

  public static <T extends Enum<T>> T random(Class<T> ec) {
    return random(ec.getEnumConstants()); //获取枚举的所有实例
  }

  public static <T> T random(T[] values) {  //从values数组中随机选取一个
    return values[rand.nextInt(values.length)];
  }
} ///:~
