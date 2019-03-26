package 面试题代码;

/**
 * @version 1.0
 * @Description: volatile测试
 * @author: hxw
 * @date: 2019/3/25 23:55
 */
public class VolatileTest2 {

    volatile static int start = 3;
    volatile static int end = 6;

    public static void main(String[] args){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (start < end){
                }
                System.out.println("t1跳出循环"); //按照常理应该永远不会执跳出循环的，但实际运行时跳出了
                //这是因为，一旦线程A的循环时，执行了线程B，start有可能先更新成6，造成了一瞬间 start == end，从而跳出while循环的可能性
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                start+=3;
                end+=3;
            }
        });

        t1.start();
        t2.start();
    }
}
