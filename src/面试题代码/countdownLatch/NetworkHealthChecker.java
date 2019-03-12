package 面试题代码.countdownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/3/11 16:31
 */
public class NetworkHealthChecker extends BaseHealthChecker {

    public NetworkHealthChecker (CountDownLatch latch)  {
        super("Network Service", latch);
    }

    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }

}
