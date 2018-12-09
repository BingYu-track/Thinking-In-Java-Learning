package generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/12/9 13:49
 */
public class Wildcards {
    //原生Holder
    static void rawArgs(Holder holder, Object arg) {
         holder.set(arg); // Warning: Unchecked call to set(T) as a member of the raw type Holder  没有检查的异常，调用set(T)方法
        // holder.set(new Wildcards()); // 与上面相同的警告
        // 不能这样做；因为没有“T”类型:
        // T t = holder.get();
        // 可以调用，但只能返回Object类，失去了类型信息:
        Object obj = holder.get();
    }

    // 带无界通赔符Holder<?>: 类似于rawArgs()，但错误而不是警告
    static void unboundedArg(Holder<?> holder, Object arg) {
        // holder.set(arg); // Error: set(capture of ?) in Holder<capture of ?> cannot be applied to (Object)
        // holder.set(new Wildcards()); // Same error
        // Can’t do this; don’t have any ‘T’:
        // T t = holder.get();
        // OK, but type information has been lost:
        Object obj = holder.get();
    }

    static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        // holder.set(arg); // Error: set(capture of ? extends T) in Holder<capture of ? extends T> cannot be applied to (T)
        T t = holder.get();
        return t;
    }

    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        holder.set(arg);
        // T t = holder.get(); // Error: Incompatible types: found Object, required T
        // OK, but type information has been lost:
        Object obj = holder.get();
    }

    public static void main(String[] args){
        Holder raw = new Holder<Long>();
        // Or:
        raw = new Holder();
        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();
        Long lng = 1L;
        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);
        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);
        Object r1 = exact1(raw); // Warnings: Unchecked conversion from Holder to Holder<T> Unchecked method invocation: exact1(Holder<T>) is applied to (Holder)
        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded); // 必须返回Object
        Long r4 = exact1(bounded);  //必须返回Long或Long的父类
        Long r5 = Wildcards.exact2(raw, lng);// Warnings: Unchecked conversion from Holder to Holder<Long> Unchecked method invocation: exact2(Holder<T>,T) is applied to (Holder,Long)
// 由于raw是原生Holder，而exact2()方法由于传了lng，因此此时exact2()方法的参数泛型是Holder<Long>，因此报警告
        Long r6 = exact2(qualified, lng);
        // Long r7 = exact2(unbounded,lng); // Error: exact2(Holder<T>,T) cannot be applied to (Holder<capture of ?>,Long)
        // Long r8 = exact2(bounded, lng); // Error: exact2(Holder<T>,T) cannot be applied to (Holder<capture of ? extends Long>,Long)
         Long r9 = wildSubtype(raw,lng); // Warnings: Unchecked conversion from Holder to Holder<? extends Long> Unchecked method invocation: wildSubtype(Holder<? extends T>,T) is applied to (Holder,Long)
        Long r10 = wildSubtype(qualified, lng);
        // OK, but can only return Object:
        Object r11 = wildSubtype(unbounded,lng);//Holder<?> unbounded,Long    (Holder<? extends T> holder, T arg)
        Long r12 = wildSubtype(bounded, lng); // Holder<? extends Long> bounded
        // wildSupertype(raw, lng); // Warnings:
        // Unchecked conversion from Holder
        // to Holder<? super Long>
        // Unchecked method invocation:
        // wildSupertype(Holder<? super T>,T)
        // is applied to (Holder,Long)
        wildSupertype(qualified, lng);
        // wildSupertype(unbounded, lng); // Error:
        // wildSupertype(Holder<? super T>,T) cannot be
        // applied to (Holder<capture of ?>,Long)
        // wildSupertype(bounded, lng); // Error:
        // wildSupertype(Holder<? super T>,T) cannot be
        // applied to (Holder<capture of ? extends Long>,Long)
        Double d = new Double(2);
        List<?> list = new ArrayList<>();

    }

    @Test
    public static  <T> void test1(List<? extends T> a, T b){

    }
}
