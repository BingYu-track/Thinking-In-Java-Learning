package interfaces.nesting;

/**
 * @Description:嵌套接口
 * @Author:hxw
 * @Date:2018/4/27 17:56
 */
public class NestingInterfaces {

    public class BImp implements A.B {
        public void f() {}
    }
    class CImp implements A.C {
        public void f() {}
    }
    // 无法实现私有接口，除非在定义该接口的类A中才能使用:
    //! class DImp implements A.D {
    //! public void f() {}
    //! }
    class EImp implements E {
        public void g() {}
    }
    class EGImp implements E.G {
        public void f() {}
    }
    class EImp2 implements E {
        public void g() {}
        class EG implements E.G {
            public void f() {}
        }
    }
    public static void main(String[] args) {
        A a = new A();
        // Can’t access A.D:
        //! A.D ad = a.getD();
        // 无法返回任何类型除了A.D:
        // A.DImp2 di2 = a.getD();  //报错：返回不匹配的类型
        // Cannot access a member of the interface:
        //! a.getD().f();
        // Only another A can do anything with getD():
        A a2 = new A();
        a2.receiveD(a.getD());
    }
}
