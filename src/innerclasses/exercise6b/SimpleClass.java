package innerclasses.exercise6b;

import innerclasses.exercise6.SimpleInterface;

public class SimpleClass {

    protected class Inner implements SimpleInterface {
        // Force constructor to be public:
        public Inner() {}
        public void f() {
            System.out.println("inner.f()");
        }
    }
}
