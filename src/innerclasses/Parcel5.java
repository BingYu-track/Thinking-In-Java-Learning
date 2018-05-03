package innerclasses;

public class Parcel5 {

    public Destination destination(String s) {

        class PDestination implements Destination { //局部内部类 在方法之外是无法访问的
            private String label;
            private PDestination(String whereTo) {
                label = whereTo;
            }
            public String readLabel() { return label; }
        }

        return new PDestination(s);
    }
    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
    }
}
