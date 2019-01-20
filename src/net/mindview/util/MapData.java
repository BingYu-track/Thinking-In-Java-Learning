//: net/mindview/util/MapData.java
// A Map filled with data using a generator object.
package net.mindview.util;
import java.util.*;

public class MapData<K,V> extends LinkedHashMap<K,V> {

  // A single Pair Generator: 单个Pair对象生产器
  public MapData(Generator<Pair<K,V>> gen, int quantity) {
    for(int i = 0; i < quantity; i++) {
      Pair<K,V> p = gen.next(); //通过产生Pair对象的key,value给map
      put(p.key, p.value);
    }
  }

  // Two separate Generators:
  public MapData(Generator<K> genK, Generator<V> genV, int quantity) {
    for(int i = 0; i < quantity; i++) {
      put(genK.next(), genV.next()); //单独生产key和,value
    }
  }

  // A key Generator and a single value: 一个key生成器和一个写死的value
  public MapData(Generator<K> genK, V value, int quantity){
    for(int i = 0; i < quantity; i++) {
      put(genK.next(), value);
    }
  }

  // An Iterable and a value Generator: key迭代器和value生成器
  public MapData(Iterable<K> genK, Generator<V> genV) {
    for(K key : genK) {
      put(key, genV.next());
    }
  }

  // An Iterable and a single value: 一个key迭代器和value
  public MapData(Iterable<K> genK, V value) {
    for(K key : genK) {
      put(key, value);
    }
  }

  // Generic convenience methods:
  public static <K,V> MapData<K,V> map(Generator<Pair<K,V>> gen, int quantity) {
    return new MapData<K,V>(gen, quantity);
  }

  public static <K,V> MapData<K,V> map(Generator<K> genK, Generator<V> genV, int quantity) {
    return new MapData<K,V>(genK, genV, quantity);
  }

  public static <K,V> MapData<K,V> map(Generator<K> genK, V value, int quantity) {
    return new MapData<K,V>(genK, value, quantity);
  }

  public static <K,V> MapData<K,V> map(Iterable<K> genK, Generator<V> genV) {
    return new MapData<K,V>(genK, genV);
  }

  public static <K,V> MapData<K,V> map(Iterable<K> genK, V value) {
    return new MapData<K,V>(genK, value);
  }

} ///:~
