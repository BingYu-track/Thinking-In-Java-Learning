package polymorphism;

public class Shared {

    private int refcount = 0; //1
    private static long counter = 0; //跟踪Shared的实例数量
    private final long id = counter++; //1
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
    public String toString() {
        return "Shared " + id;
    }
}
