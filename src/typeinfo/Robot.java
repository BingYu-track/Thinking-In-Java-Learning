package typeinfo;

import java.util.List;

/**
* @Description: 机器人接口
* @Author:hxw
* @Date:2018/9/10 22:25
*/
public interface Robot {

    //名字
    String name();

    //模型
    String model();

    //描述Robot行为的方法(这个行为包含"描述"和"命令"两种行为)
    List<Operation> operations();

    //Test是一个静态内部类
    class Test {
        public static void test(Robot r) {
            if(r instanceof Null){
                System.out.println("[Null Robot]");
            }
            System.out.println("Robot name: " + r.name());
            System.out.println("Robot model: " + r.model());
            for(Operation operation : r.operations()) {
                System.out.println(operation.description());
                operation.command();
            }
        }
    }
}
