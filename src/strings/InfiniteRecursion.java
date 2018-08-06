package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description: 在toString使用this的陷阱
 * @author: hxw
 * @date: 2018/8/6 8:58
 */
public class InfiniteRecursion {

    public String toString() {
        /*这里会导致递归调用this.toString()方法，因此下面main方法执行会报java.lang.StackOverflowError,正确写法是将this改为super.toString()
          调用其父类Object的toString方法
         */
        return " InfiniteRecursion address: " + this + "\n";
    }
    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
        for(int i = 0; i < 10; i++){
            v.add(new InfiniteRecursion());
        }
        System.out.println(v);
    }
}
