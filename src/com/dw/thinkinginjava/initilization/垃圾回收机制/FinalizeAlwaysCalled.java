package com.dw.thinkinginjava.initilization.垃圾回收机制;

public class FinalizeAlwaysCalled {

    protected void finalize() {
        System.out.println("finalize() called");
    }
    public static void main(String args[]) {
        new FinalizeAlwaysCalled();
        System.gc();
        System.runFinalization();
    }
    /*
    finalize() ----是Object的protected方法，子类可以覆盖该方法以实现资源清理工作，GC在回收对象之前会调用该方法

    System.gc() ---告诉垃圾收集器打算进行垃圾收集，而垃圾收集器进不进行收集是不确定的(注释掉System.runFinalization()并多次运行main方法会发现有时不会调用finalize方法)。

    System.runFinalization() ---强制垃圾回收机制尽可能的回收没有被利用的对象，以释放出其占用的内存。

    System.gc()与System.runFinalization()方法会增加finalize方法执行的机会，但不可盲目依赖它们。

    注意：gc 只能清除在堆上分配的内存(纯java语言的所有对象都在堆上使用new分配内存),而不能清除栈上分配的内存（当使用JNI技术时,可能会在栈上分配内 存,例如java调用c程序，
          而该c程序使用malloc分配内存时）.因此,如果某些对象被分配了栈上的内存区域,那gc就管不着了,对这样的对象进行 内存回收就要靠finalize()。
     */
}
