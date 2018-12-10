package generics;

/**
 * @version 1.0
 * @Description: 捕获转换
 * @author: hxw
 * @date: 2018/12/9 22:54
 */
public class CaptureConversion {

    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder) {
        f1(holder); // Call with captured type 在这里，参数类型在f2调用f1的时候被捕获了,Holder<?> holder转为了确切类型
    }

    //@SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Holder raw = new Holder<Integer>(1);
         f1(raw); // 产生警告：类型转换捕获,f1方法需要一个带有类型参数的Holder但是提供的是一个原型
        f2(raw); // No warnings
        Holder rawBasic = new Holder();
        rawBasic.set(new Object()); // Warning
        f2(rawBasic); // No warnings
        // Upcast to Holder<?>, still figures it out:
        Holder<?> wildcarded = new Holder<Double>(1.0);
        f2(wildcarded);
    }
}
