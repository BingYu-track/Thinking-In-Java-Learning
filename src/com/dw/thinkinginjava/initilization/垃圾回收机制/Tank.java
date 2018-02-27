package com.dw.thinkinginjava.initilization.垃圾回收机制;

public class Tank {

    static int counter;
    int id = counter++;
    boolean full;

    public Tank() {
        System.out.println("Tank " + id + "被创建");
        full = true;
    }
    public void empty() {
        full = false;
    }

    protected void finalize(){
        if(full){
            System.out.println("Error: tank " + id + " 清除前必须是空的");
        }else {
            System.out.println("Tank " + id + " 清除成功");
        }
    }

    public String toString() { return "Tank " + id; }
}
