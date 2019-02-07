package containers;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/6 22:42
 */
public class Test {

    public static void main(String[] args){
        Object counter = new Object();
        System.out.println(counter);
        ReferenceQueue refQueue = new ReferenceQueue<>();
        PhantomReference<Object> p = new PhantomReference<>(counter, refQueue);
        counter = null;
        System.gc();
        try {
            // Remove 是一个阻塞方法，可以指定 timeout，或者选择一直阻塞
            Reference<Object> ref = refQueue.remove(1000L);
            if (ref != null) {
                // do something
                System.out.println(ref.get());
            }
        } catch (InterruptedException e) {
            // Handle it
        }
    }

}
