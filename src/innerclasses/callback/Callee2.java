package innerclasses.callback;

class Callee2 extends MyIncrement {

    private int i = 0;
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }
    private class Closure implements Incrementable { //闭包实现Incrementable接口
        public void increment() {
        // Specify outer-class method, otherwise
        // you’d get an infinite recursion:指定外部类方法，否则将得到无限递归：
            Callee2.this.increment(); //调用外部类的increment()方法
        }
    }
    Incrementable getCallbackReference() {
        return new Closure();
    }
}
