package com.dw.thinkinginjava.initilization.垃圾回收机制;

public class TankWithTerminationCondition {

    public static void main(String[] args){
        new Tank().empty();
        new Tank();
        // Don't empty the second one
        System.gc(); // Force finalization?
        System.runFinalization();

        /*
        输出结果：
                Tank 0被创建
                Tank 1被创建
                Error: tank 1 清除前必须是空的
                Tank 0 清除成功

                我们创建了两个没有引用的Tank实例，因为这些引用在调用GC()时是在堆内存中的，所以它们不会被清理，不会被最终确定下来；
                另一种选择是在希望它们被垃圾收集时将引用设置为0。

        */
    }
}
