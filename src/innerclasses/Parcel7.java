package innerclasses;

public class Parcel7 {

    public Contents contents() {
        return new Contents() { //匿名内部类，相当于创建了一个实现了Contents接口的对象
            private int i = 11;
            public int value() { return i; }
        }; // Semicolon required in this case
    }
    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
    }
}
