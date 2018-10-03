package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/10/3 13:40
 */
public class E07_IterableFibonacci2 {
    public static void main(String[] args) {
        for(int i : new IterableFibonacci(18))
            System.out.print(i + " ");
    }
}
