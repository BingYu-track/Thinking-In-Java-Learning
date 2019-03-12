package 面试题代码.countdownLatch;

/**
 * @version 1.0
 * @Description: 死锁测试
 * @author: hxw
 * @date: 2019/3/11 18:30
 */
public class Main {

    public static void main(String[] args) {
        boolean result = false;
        try {
            result = ApplicationStartupUtil.checkExternalServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("External services validation completed !! Result was :: "+ result);
    }

}
