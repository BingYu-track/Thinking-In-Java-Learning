package generics;

import java.util.Iterator;

/**
 * @version 1.0
 * @Description: 通过继承创建适配器类，这样就相当于把Fibonacci包装了一层，不再需要重新写一个类(当然也可以使用组和)
 * @author: hxw
 * @date: 2018/9/25 22:44
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {

    private int n;
    public IterableFibonacci(int count) {
        n = count;
    }

    public Iterator<Integer> iterator() {
        //匿名内部类
        return new Iterator<Integer>() {
            public boolean hasNext() { return n > 0; }
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }
    public static void main(String[] args) {
        for(int i : new IterableFibonacci(18))
            System.out.print(i + " ");
    }
}
