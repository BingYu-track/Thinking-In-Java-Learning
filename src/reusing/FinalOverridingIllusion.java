package reusing;

public class FinalOverridingIllusion {

    public static void main(String[] args){
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();

        OverridingPrivate op = op2; //OverridingPrivate2继承了OverridingPrivate，因此可以向上转型
        //op.f();
        //op.g(); 无法调用
        WithFinals wf = op2;
        //wf.f();
        //wf.g(); 同样无法访问
    }
}
