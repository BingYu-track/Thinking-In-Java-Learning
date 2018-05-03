package innerclasses;

public class Parcel9 {

    // Argument must be final to use inside
    // anonymous inner class:
    public Destination destination(final String dest) { //注意：当定义一个匿名内部类，并且希望它使用一个在外部定义的对象，那么编译器会要求其参数引用是final的，jdk1.8把它默认设置为final的了
        return new Destination() {
            private String label = dest;
            public String readLabel() { return label; }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
        String s = d.readLabel();
        System.out.println();
    }
}
