package generics;

import java.util.Iterator;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/10/3 13:38
 */
public class IterableFibonacci02 implements Iterable<Integer> {

    private Fibonacci fib = new Fibonacci();
    private int n;
    public IterableFibonacci02(int count) { n = count; }
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() { return n > 0; }
            public Integer next() {
                --n;
                return fib.next();
            }
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }
}
