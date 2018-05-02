package innerclasses;

public class DotThis {

    void f() { System.out.println("DotThis.f()"); }
    public class Inner {
        public DotThis outer() {
            return DotThis.this; //外部类名后面紧跟圆点和this
        // A plain "this" would be Inner’s "this"
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}
