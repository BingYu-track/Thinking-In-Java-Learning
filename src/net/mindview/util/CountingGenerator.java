//: net/mindview/util/CountingGenerator.java
// Simple generator implementations.
package net.mindview.util;

/**
 * 计数生成器
 */
public class CountingGenerator {

  public static class Boolean implements Generator<java.lang.Boolean> {
    private boolean value = false;
    public java.lang.Boolean next() {
      value = !value; // Just flips back and forth
      return value;
    }
  }

  public static class Byte implements Generator<java.lang.Byte> {
    private byte value = 0;
    public java.lang.Byte next() { return value++; }
  }

  static char[] chars = ("abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

  public static class Character implements Generator<java.lang.Character> {
    int index = -1;
    //不断返回的大小写字母
    public java.lang.Character next() {
      index = (index + 1) % chars.length; //这里不断对26*2=52进行取余，再小于52之前，取余数都是其自身，当刚好(index + 1)等于52时，整除取余为0，因此index重新等于0了，开始重头开始
      return chars[index];
    }
  }

  public static class String implements Generator<java.lang.String> {
    private int length = 7;
    Generator<java.lang.Character> cg = new Character(); //内部持有Character
    public String() {}

    public String(int length) {
      this.length = length;
    }

    public java.lang.String next() {
      char[] buf = new char[length];
      for(int i = 0; i < length; i++)
        buf[i] = cg.next();//使用Character来填充char数组
      return new java.lang.String(buf);
    }
  }

  public static class Short implements Generator<java.lang.Short> {
    private short value = 0;
    public java.lang.Short next() { return value++; }
  }

  public static class Integer implements Generator<java.lang.Integer> {
    private int value = 0;
    public java.lang.Integer next() { return value++; }
  }

  public static class Long implements Generator<java.lang.Long> {
    private long value = 0;
    public java.lang.Long next() { return value++; }
  }

  public static class Float implements Generator<java.lang.Float> {
    private float value = 0;
    public java.lang.Float next() {
      float result = value;
      value += 1.0;
      return result;
    }
  }

  public static class Double implements Generator<java.lang.Double> {
    private double value = 0.0;
    public java.lang.Double next() {
      double result = value;
      value += 1.0;
      return result;
    }
  }

} ///:~
