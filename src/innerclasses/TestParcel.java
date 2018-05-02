package innerclasses;

public class TestParcel {

    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.contents();
        Destination d = p.destination("Tasmania");
        //非法，无法访问私有的内部类 Illegal -- can’t access private class:
        //! Parcel4.PContents pc = p.new PContents();
    }
}
