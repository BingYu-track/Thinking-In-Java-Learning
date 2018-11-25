package generics;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/25 21:57
 */
public class ArrayOfGeneric {

    static final int SIZE = 100;
    static Generic<Integer>[] gia;
    //@SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //gia = (Generic<Integer>[])new Object[SIZE]; // 编译通过，但运行时产生ClassCastException:[Ljava.lang.Object; cannot be cast to [Lgenerics.Generic; Object数组不能转为Generic数组
        // 运行时类型是原始(擦除)类型
        gia = (Generic<Integer>[])new Generic[SIZE]; //原始类型显示强转
        System.out.println(gia.getClass().getSimpleName()); //Generic[]
        gia[0] = new Generic<Integer>(); //编译通过
        //! gia[1] = new Object(); // Compile-time error 很明显类型不匹配
        //! gia[2] = new Generic<Double>(); //在编译时发现类型不匹配
    }

    /**
     * 不允许创建泛型数组的原因
     */
/*    @Test
    public void reason(){
        List<String>[] lsa = new List<String>[10]; // Not really allowed.
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1] = li; // Unsound, but passes run time store check
        String s = lsa[1].get(0); // Run-time error: ClassCastException.
        *//*
        解释：如果允许泛型数组的存在（reason方法中第1行代码编译通过）那么在最后一行代码就会报出ClassCastException，
        因为lsa[1]是List<Integer>。Java设计者本着首要保证类型安全（type-safety）的原则，不允许泛型数组的存在，使得编译期就可以检查到这类错误。
        *//*
    }*/

    /**
     * 解决方法1：使用通配符创建泛型数组
     */
    @Test
    public void solve1(){
        List<String>[] lsa = (List<String>[])new List<?>[10];                //1
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        // Correct.
        oa[1] = li;
        // 运行时错误，但强制转换是显式的
        String s = lsa[1].get(0);//2
/**
         在第1处，用?取代了确定的参数类型。再显示的进行了类型转化
         */
    }

    /**
     * 解决方法2： 使用java.util.reflect.Array，可以不使用通配符，而达到泛型数组的效果
     */
    @Test
    public void solve2(){
        List<String>[] lsa = (List<String>[]) Array.newInstance(ArrayList.class, 4);     //1
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        // Correct.
        oa[1] = li;
        // Run time error, but cast is explicit.
        String s = lsa[1].get(0); //2
        /*
            可以看到，我们利用了Array.newInstance()生成了泛型数组，这里没有使用任何通配符，在第2处也没有做显式的类型转换，但是在第1处，仍然存在显式类型转换
        */
    }

    //总结：要想创建泛型数组，就必须先创建一个原始类型的数组(不带泛型)，然后再显示的进行强转
}
