package polymorphism;

public class Shared {

    private int refcount = 0;
    private static long counter = 0; //跟踪Shared的实例数量
    private final long id = counter++;
    public Shared() {
        System.out.println("Creating " + this);
    }
    public void addRef() {
        refcount++;
    }
    protected void dispose() {
        if(--refcount == 0)
            System.out.println("Disposing " + this);
    }

    protected void finalize() {
        if(refcount != 0)
            System.out.println("Error: 共享对象Shared仍然被引用中，不能清理！");
    }
    public String toString() {
        return "Shared " + id;
    }
}
