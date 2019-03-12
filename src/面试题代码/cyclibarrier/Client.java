package 面试题代码.cyclibarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @version 1.0
 * @Description:  CycliBarrier的简单应用
 * @author: hxw
 * @date: 2019/3/12 9:11
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new TourGuideTask()); //第一个参数，表示那个一起执行的线程个数。第二个参数，表示线程都处于barrier时，一起执行之前，先执行的一个线程。
        Executor executor = Executors.newFixedThreadPool(3);
        executor.execute(new TravelTask(cyclicBarrier,"哈登",5)); //传入相同的CyclicBarrier
        executor.execute(new TravelTask(cyclicBarrier,"保罗",3));
        executor.execute(new TravelTask(cyclicBarrier,"戈登",1));
        //cyclicBarrier.reset();
        Thread.sleep(8000);
        executor.execute(new TravelTask(cyclicBarrier,"哈登",5)); //传入相同的CyclicBarrier
        executor.execute(new TravelTask(cyclicBarrier,"保罗",3));
        executor.execute(new TravelTask(cyclicBarrier,"戈登",1));
        //当这3个线程都处于等待状态后，就开始唤醒TourGuideTask线程并执行，执行完后，前面3个线程同时唤醒并执行
    }
}
