package generics;

import java.io.Serializable;

/**
 * @version 1.0
 * @Description: 泛型的动作
 * @author: hxw
 * @date: 2018/10/8 21:36
 */
public class GenericHolder<T> {
    private T obj;

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }
    public static void main(String[] args) {
        GenericHolder<String> holder = new GenericHolder<String>();
        holder.set("Item");
        String s1 = holder.get();
    }
    /*
    加上泛型后反编译，泛型加泛型和不加泛型反编译后的字节码是相同的，实际上，这里两个类型产生的字节码是一致的。对进入set()
    的检查是不需要的，编译器会进行。但从get()返回的值的强转却是需要的，只不过：在 SimpleHolder，强转需要手动进行，
    而在GenericHolder中 强转是由编译器自动插入的。可见：泛型中所有动作都是发生在边界处—–对传进来的值进行额外编译期检查，
    并插入对传递出去的值的转型。这里的边界就是指的发生 “传进来”(set)、 “传出去“”(get)动作的地方。
public class generics.GenericHolder<T> {
  public generics.GenericHolder();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public void set(T);
    Code:
       0: aload_0
       1: aload_1
       2: putfield      #2                  // Field obj:Ljava/lang/Object;
       5: return

  public T get();
    Code:
       0: aload_0
       1: getfield      #2                  // Field obj:Ljava/lang/Object;
       4: areturn

  public static void main(java.lang.String[]);
    Code:
       0: new           #3                  // class generics/GenericHolder
       3: dup
       4: invokespecial #4                  // Method "<init>":()V
       7: astore_1
       8: aload_1
       9: ldc           #5                  // String Item
      11: invokevirtual #6                  // Method set:(Ljava/lang/Object;)V
      14: aload_1
      15: invokevirtual #7                  // Method get:()Ljava/lang/Object;
      18: checkcast     #8                  // class java/lang/String
      21: astore_2
      22: return
}

     */
}
