package 面试题代码.countdownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/3/11 18:28
 */
public class CacheHealthChecker extends BaseHealthChecker{

    public CacheHealthChecker (CountDownLatch latch)  {
        super("Cache Service", latch);
    }

    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }

}
