//: generics/coffee/CoffeeGenerator.java
// Generate different types of Coffee:
package generics.coffee;
import java.util.*;
import net.mindview.util.*;

/**
* @Description: 实现泛型接口
* @Author:hxw
* @Date:2018/9/25 22:33
*/
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

  private Class[] types = { Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class, };
  private static Random rand = new Random( 47);
  // For iteration:
  private int size = 0;

  public CoffeeGenerator() {

  }

  public CoffeeGenerator(int sz) {
    size = sz;
  }


 //实现Generator接口的next方法
  public Coffee next() {
    try {
      Coffee coffee = (Coffee) types[rand.nextInt(types.length)].newInstance();
      return coffee;
      // Report programmer errors at run time:
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }

  //内部类实现Iterator接口
  class CoffeeIterator implements Iterator<Coffee> {
    int count = size;
    public boolean hasNext() { return count > 0; }
    public Coffee next() {
      count--;
      return CoffeeGenerator.this.next();
    }
    public void remove() { // Not implemented
      throw new UnsupportedOperationException();
    }
  }

  //实现Iterable接口的iterator方法
  public Iterator<Coffee> iterator() {
    return new CoffeeIterator(); //返回内部类迭代器
  }

  public static void main(String[] args) {
    CoffeeGenerator gen = new CoffeeGenerator();
    for(int i = 0; i < 5; i++)
      System.out.println(gen.next());
    System.out.println("-----------------");
    for(Coffee c : new CoffeeGenerator(5)) //这里foreach实际是调用的内部类CoffeeIterator迭代器的方法
      System.out.println(c);
  }
} /* Output:
Americano 0
Latte 1
Americano 2
Mocha 3
Mocha 4
Breve 5
Americano 6
Latte 7
Cappuccino 8
Cappuccino 9
*///:~
