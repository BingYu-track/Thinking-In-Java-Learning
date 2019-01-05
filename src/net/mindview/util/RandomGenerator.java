//: net/mindview/util/RandomGenerator.java
// Generators that produce random values.
package net.mindview.util;
import java.util.*;

public class RandomGenerator {
  private static Random r = new Random(47);

  public static class Boolean implements Generator<java.lang.Boolean> {
    public java.lang.Boolean next() {
      return r.nextBoolean(); //返回下一个伪随机数，它是取自此随机数生成器序列的均匀分布的 boolean 值
    }
  }

  public static class Byte implements Generator<java.lang.Byte> {
    public java.lang.Byte next() { //因为已经定义了一个静态内部类Byte，因此在使用sun工具包中的Byte需要加上包名
      return (byte)r.nextInt();
    }
  }

  public static class Character implements Generator<java.lang.Character> {
    public java.lang.Character next() {
      return CountingGenerator.chars[r.nextInt(CountingGenerator.chars.length)]; //从CountingGenerator中的char数组中随机选择一个
    }
  }

  public static class String extends CountingGenerator.String {
      // Plug in the random Character generator:
      {
        cg = new Character();
      } // Instance initializer
      public String() {}

      public String(int length) {
        super(length);
      }

  }

  public static class Short implements Generator<java.lang.Short> {
    public java.lang.Short next() {
      return (short)r.nextInt();
    }
  }

  public static class Integer implements Generator<java.lang.Integer> {
    private int mod = 10000;
    public Integer() {}
    public Integer(int modulo) { mod = modulo; }
    public java.lang.Integer next() {
      return r.nextInt(mod);
    }
  }

  public static class Long implements Generator<java.lang.Long> {
    private int mod = 10000;
    public Long() {}
    public Long(int modulo) {
      mod = modulo;
    }
    public java.lang.Long next() {
      return new java.lang.Long(r.nextInt(mod));
    }
  }

  public static class Float implements Generator<java.lang.Float> {
    public java.lang.Float next() {
      // Trim all but the first two decimal places:
      int trimmed = Math.round(r.nextFloat() * 100);
      return ((float)trimmed) / 100;
    }

  }

  public static class Double implements Generator<java.lang.Double> {
    public java.lang.Double next() {
      long trimmed = Math.round(r.nextDouble() * 100);
      return ((double)trimmed) / 100;
    }
  }

} ///:~
