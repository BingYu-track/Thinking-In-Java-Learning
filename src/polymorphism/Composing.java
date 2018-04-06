package polymorphism;

public class Composing {

    private Shared shared;
    private static long counter = 0; //跟踪Composing的实例数量
    private final long id = counter++;
    public Composing(Shared shared) {
        System.out.println("Creating " + this);
        this.shared = shared; //将共享对象shared附着到Composing类上
        this.shared.addRef(); //一旦附着，增加对象shared的"被引用数(即shared被其它对象引用了几次)"
    }
    protected void dispose() {
        System.out.println("disposing " + this); //一旦一个Composing对象被清理，就减少共享对象shared的被引用数
        shared.dispose();
    }
    public String toString() {
        return "Composing " + id;
    }
}
