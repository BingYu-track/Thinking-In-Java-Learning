package polymorphism;

public class Son extends Father {

    public Son f(){  //这里子类Son返回的是它父类的子类，也算是重写
        System.out.println("son");
        return new Son();
    }

    public static void main(String[] args){
        Father father = new Son();
        father.f();
    }
}
