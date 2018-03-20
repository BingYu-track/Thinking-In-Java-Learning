package com.dw.thinkinginjava.initilization.非静态初始化;

public class Mugs {
    Mug mug1;
    Mug mug2;
    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        System.out.println("mug1和mug2初始化了");
    }

   public Mugs(){
        System.out.println("Mugs()");
    }

    Mugs(int i){
        System.out.println("Mugs(int)");
    }

    public static void main(String[] args){
        System.out.println("进入main方法");
        new Mugs();  //----a
        System.out.println("new Mugs() completed");
        new Mugs(1);//----b
        System.out.println("new Mugs(1) completed");
    }

    /*
      初始化顺序：
      a.
          进入main方法
          Mug(1)
          Mug(2)
          mug1和mug2初始化了
          Mugs()
      new Mugs() completed
      b.
          Mug(1)
          Mug(2)
          mug1和mug2初始化了
          Mugs(int)
       new Mugs(1) completed

       总结：非静态成员变量只有在创建对象时才会初始化
     */
}
