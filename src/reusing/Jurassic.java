package reusing;

public class Jurassic {

    public static void main(String[] args){
        Dinosaur n = new Dinosaur();
        n.f();
        n.i = 40;
        n.j++;
        n.x = new SmallBrain();
    }
}
