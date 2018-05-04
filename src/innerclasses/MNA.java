package innerclasses;

class MNA {

    private void f() {
        System.out.println("外围类MNA的f()方法");
    }
    class A {
        private void g() {
            System.out.println("内部类A的g()方法");
        }
        public class B {
            void h() {
                g();
                f();
            }
        }
    }
    public static void main(String[] args){
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
}
