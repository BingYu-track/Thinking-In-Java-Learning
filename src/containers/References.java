package containers;

import java.lang.ref.*;
import java.util.LinkedList;

/**
 * @version 1.0
 * @Description: 这段代码未理解？
 * @author: hxw
 * @date: 2019/2/10 16:02
 */
public class References {

    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();
    public static void checkQueue() {
        Reference<? extends VeryBig> inq = rq.poll(); //轮询队列rq，查看是否存在可用的引用对象,如果存在一个立即可用的对象，则从该队列中移除此对象并返回。否则此方法立即返回 null。
        if(inq != null){
            System.out.println("In queue: " + inq.get()); //返回此引用对象的指示对象。如果此引用对象已经由程序或垃圾回收器清除，则此方法将返回 null
        }
    }

    public static void main(String[] args) {
        int size = 10;
        // Or, choose size via the command line:
        if(args.length > 0){
            size = new Integer(args[0]);
        }
        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<SoftReference<VeryBig>>();
        for(int i = 0; i < size; i++) {
            sa.add(new SoftReference<VeryBig>(new VeryBig("Soft " + i), rq));
            System.out.println("Just created: " + sa.getLast());
            checkQueue();
        }
        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<WeakReference<VeryBig>>();
        for(int i = 0; i < size; i++) {
            wa.add(new WeakReference<VeryBig>(new VeryBig("Weak " + i), rq));
            System.out.println("Just created: " + wa.getLast());
            checkQueue();
        }
        SoftReference<VeryBig> s = new SoftReference<VeryBig>(new VeryBig("Soft"));
        WeakReference<VeryBig> w = new WeakReference<VeryBig>(new VeryBig("Weak"));
        System.gc();
        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<PhantomReference<VeryBig>>();
        for(int i = 0; i < size; i++) {
            pa.add(new PhantomReference<VeryBig>(new VeryBig("Phantom " + i), rq));
            System.out.println("Just created: " + pa.getLast());
            checkQueue();
        }
    }

}
