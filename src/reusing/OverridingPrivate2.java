package reusing;

public class OverridingPrivate2 extends OverridingPrivate {


    public final void f(){
        System.out.println("OverridingPrivate2调用f方法");
    }

    public void g(){
        System.out.println("OverridingPrivate2调用g方法");
    }
}
