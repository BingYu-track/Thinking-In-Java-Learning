package polymorphism;

public class PrivateOverride {

    private void f(){
        System.out.println("private f()");
    }

    public static void main(String[] args){
        PrivateOverride po = new Derived();
        po.f();
    }
    /*
     private f()
    */
}
