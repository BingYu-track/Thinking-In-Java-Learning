package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/1 23:18
 */
public class E21_ConstructorExceptions {
    public static void main(String args[]) {
        try {
            //这里会调用DerivedWE父类的构造器BaseWithException，其中BaseWithException的构造器抛出了异常
            new DerivedWE();
        } catch(Except1 ex1) {
            System.out.println("Caught " + ex1);
        }
    }
}
