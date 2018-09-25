package generics;

import net.mindview.util.*;

/**
 * @version 1.0
 * @Description: 斐波纳契数列生成器
 * @author: hxw
 * @date: 2018/9/25 22:28
 */
public class Fibonacci implements Generator<Integer> {
    private int count = 0;

    public Integer next() {
        return  fib(count++);
    }

    private int fib(int n) {
        if(n < 2) {
            return 1;
        }
        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for(int i = 0; i < 18; i++)
            System.out.print(gen.next() + " ");
    }
}
