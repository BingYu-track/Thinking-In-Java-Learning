package interfaces.nesting;

/**
* @Description:类中嵌套接口
* @Author:hxw
* @Date:2018/4/27 19:45
*/
class A {
    interface B {
        void f();
    }
    public class BImp implements B {
        public void f() {}
    }
    private class BImp2 implements B {
        public void f() {}
    }
    //----------接口B------------
    public interface C { //公有接口
        void f();
    }
    class CImp implements C {
        public void f() {}
    }
    private class CImp2 implements C {
        public void f() {}
    }
    //----------接口C-----------
    private interface D { //发现类中嵌套的接口可以被private修饰---私有接口
        void f();
    }
    private class DImp implements D {
        public void f() {}
    }
    public class DImp2 implements D {
        public void f() {}
    }
    //----------接口D-------------
    public D getD() {
        return new DImp2();
    }
    private D dRef;
    public void receiveD(D d) {
        dRef = d;
        dRef.f();
    }
}
