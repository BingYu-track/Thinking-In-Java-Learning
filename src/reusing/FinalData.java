package reusing;

import net.mindview.util.Print;

import java.util.Random;

public class FinalData {
    private static Random rand = new Random(47);
    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    //无法编译的常量
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;

    //公共常量
    public static final int VALUE_THREE = 39;

    //无法编译的常量
    private final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);
    //Arrays
    private final int[] a = {1,2,3,4,5,6};

    @Override
    public String toString() {
       return id + "：" + "i4 = " + i4 + "，INT_5 = " + INT_5;
    }

    public static void main(String[] args){
        FinalData fd1 = new FinalData("fd1");
       // fd1.valueOne++;  //编译器直接报错,因为valueOne是常量，无法修改
        fd1.v2.i++;  // 虽然v2是一个被final修饰的对象，但它自身是可以修改的，只是引用不能修改
       // fd1.v2 = new Value(3); //发现无法修改v2的引用
        fd1.v1 = new Value(9);
        for (int i = 0;i < fd1.a.length; i++){
            fd1.a[i]++;
        }
        //fd1.VAL_3 = new Value(1); //编译器报错，不能更改引用
        //fd1.a = new int[3]; //编译器报错，同样不能更改引用
        Print.print(fd1);
        Print.print("Creating new FinalData");
        FinalData fd2 = new FinalData("fd2");
        Print.print(fd1);
        Print.print(fd2);
        /*执行结果   i4-- private final 、 INT_5 -----static final   由于i4是每次创建对象时初始化，因此每创建FinalData对象，i4值就不一样；而INT_5由于有statuc修饰，在FinalData这个类加载时就初始化了，无法在进行修改
        fd1：i4 = 15，INT_5 = 18
        Creating new FinalData
        fd1：i4 = 15，INT_5 = 18
        fd2：i4 = 13，INT_5 = 18
        */
    }
}
