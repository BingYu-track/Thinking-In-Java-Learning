package typeinfo;
import static net.mindview.util.Print.*;
import typeinfo.interfacea.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/18 22:19
 */
public class InnerA {

    //私有内部类
    private static class C implements A {
        public void f() { print("public C.f()"); }
        public void g() { print("public C.g()"); }
        void u() { print("package C.u()"); }
        protected void v() { print("protected C.v()"); }
        private void w() { print("private C.w()"); }
    }

    public static A makeA() {
        return new C();
    }

}
