package 面试题代码;

/**
 * @version 1.0
 * @Description: volatile测试，这个例子表明了volatile并不能保证变量的原子性
 * @author: hxw
 * @date: 2019/3/25 23:32
 */
public class VolatileTest {

    public volatile static int count = 0;

    public static void main(String[] args){
        //开启10个线程
        for (int i=0;i<10;i++){
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            //每个线程当中让count值自增100次
                            for (int j=0;j<100;j++){
                                count++;
                            }
                        }
                    }
            ).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count="+count); //结果小于1000
    }

}
