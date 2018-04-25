package polymorphism;

public class Father {

    public Father f(){
        System.out.println("Father");
        return new Father();
    }
}
