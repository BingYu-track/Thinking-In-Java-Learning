package reusing;

public class OverridingPrivate extends WithFinals {

    private final void f(){
        System.out.println("OverridingPrivate调用f方法");
    }

    private void g(){
        System.out.println("OverridingPrivate调用g方法");
    }
}
