package generics;

import java.math.*;
import java.util.concurrent.atomic.*;
import java.util.*;
import static net.mindview.util.Print.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/24 22:32
 */
public class Functional {

    // Calls the Combiner object on each element to combine it with a running result, which is finally returned:
    //调用每个元素上的Combiner对象，将其与运行的结果组合在一起，最终返回：
    public static <T> T reduce(Iterable<T> seq, Combiner<T> combiner) {
        Iterator<T> it = seq.iterator();
        if(it.hasNext()) {
            T result = it.next();
            while(it.hasNext())
                result = combiner.combine(result, it.next());
            return result;
        }
        // If seq is the empty list:
        return null; // Or throw exception
    }

    // Take a function object and call it on each object in the list, ignoring the return value. The function
    // object may act as a collecting parameter, so it is returned at the end.
    //接受一个函数对象并在列表中的每个对象上调用它，忽略返回值。函数对象可能充当一个收集参数，因此它将在最后返回。
    public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> func) {
        for(T t : seq){
            func.function(t); //Collector只有MultiplyingIntegerCollector实现，从1开始乘
        }
        return func;
    }

    // Creates a list of results by calling a function object for each object in the list:
    //通过为列表中seq的每个对象调用函数对象来创建结果列表

    /**
     *
     * @param seq  参数列表
     * @param func 函数
     * @param <R>  结果数据类型
     * @param <T>  参数数据类型
     * @return
     */
    public static <R,T> List<R> transform(Iterable<T> seq, UnaryFunction<R,T> func) {
        List<R> result = new ArrayList<R>();
        for(T t : seq){
            result.add(func.function(t));
        }
        return result;
    }

    // Applies a unary predicate to each item in a sequence,and returns a list of items that produced "true":
    //对序列中的每个项应用一元断言，并返回生成“true”的元素的列表。
    public static <T> List<T> filter(Iterable<T> seq, UnaryPredicate<T> pred) {
        List<T> result = new ArrayList<T>();
        for(T t : seq){
            if(pred.test(t)){ //如果测试返回true就添加到列表中(这里只有一个实现类，用t来与bound比较大小)
                result.add(t);
            }
        }
        return result;
    }

    // To use the above generic methods, we need to create function objects to adapt to our particular needs:
    //要使用上述泛型方法，我们需要创建函数对象以适应我们的特定需求

    //Integer求和函数
    static class IntegerAdder implements Combiner<Integer> {
        public Integer combine(Integer x, Integer y) {
            return x + y;
        }
    }

    //Integer减函数
    static class IntegerSubtracter implements Combiner<Integer> {
        public Integer combine(Integer x, Integer y) {
            return x - y;
        }
    }

    //BigDecimal求和函数
    static class BigDecimalAdder implements Combiner<BigDecimal> {
        public BigDecimal combine(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    }

    //BigInteger求和函数
    static class BigIntegerAdder implements Combiner<BigInteger> {
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }

    //AtomicLong求和函数
    static class AtomicLongAdder implements Combiner<AtomicLong> {
        public AtomicLong combine(AtomicLong x, AtomicLong y) {
            // Not clear whether this is meaningful:
            return new AtomicLong(x.addAndGet(y.get()));
        }
    }

    // We can even make a UnaryFunction with an "ulp"
    // (Units in the last place):
    static class BigDecimalUlp implements UnaryFunction<BigDecimal,BigDecimal> {
        public BigDecimal function(BigDecimal x) {
            return x.ulp(); //ulp()方法 --返回此 BigDecimal 的 ulp（最后一位的单位）的大小
        }
    }

    //比较大小函数
    static class GreaterThan<T extends Comparable<T>> implements UnaryPredicate<T> {
        private T bound;
        public GreaterThan(T bound) { this.bound = bound; }
        public boolean test(T x) {
            return x.compareTo(bound) > 0;
        }
    }

    //乘法函数
    static class MultiplyingIntegerCollector implements Collector<Integer> {
        private Integer val = 1;
        public Integer function(Integer x) {
            val *= x;
            return val;
        }
        public Integer result() {
            return val;
        }
    }

    public static void main(String[] args){
        // Generics, varargs & boxing working together:
        List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Integer result = reduce(li, new IntegerAdder());
        print(result);
        result = reduce(li, new IntegerSubtracter());
        print(result);
        print(filter(li, new GreaterThan<Integer>(4)));
        print(forEach(li, new MultiplyingIntegerCollector()).result());
        print(forEach(filter(li, new GreaterThan<Integer>(4)), new MultiplyingIntegerCollector()).result());
        MathContext mc = new MathContext(7);
        List<BigDecimal> lbd = Arrays.asList(new BigDecimal(1.1, mc), new BigDecimal(2.2, mc),
                                new BigDecimal(3.3, mc), new BigDecimal(4.4, mc));
        BigDecimal rbd = reduce(lbd, new BigDecimalAdder());
        print(rbd);
        print(filter(lbd, new GreaterThan<BigDecimal>(new BigDecimal(3))));
        // Use the prime-generation facility of BigInteger:
        List<BigInteger> lbi = new ArrayList<BigInteger>();
        BigInteger bi = BigInteger.valueOf(11);
        for(int i = 0; i < 11; i++) {
            lbi.add(bi);
            bi = bi.nextProbablePrime();
        }
        print(lbi);
        BigInteger rbi = reduce(lbi, new BigIntegerAdder());
        print(rbi);
        // The sum of this list of primes is also prime:
        print(rbi.isProbablePrime(5));
        List<AtomicLong> lal = Arrays.asList(new AtomicLong(11), new AtomicLong(47), new AtomicLong(74), new AtomicLong(133));
        AtomicLong ral = reduce(lal, new AtomicLongAdder());
        print(ral);
        print(transform(lbd,new BigDecimalUlp()));
    }
}
