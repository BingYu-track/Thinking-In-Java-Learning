package innerclasses;

public class Parcel4 {

    private class PContents implements Contents { //这里私有的内部类，除了Parcel4能访问，其它外部类都无法访问(在这里可以直接看成一种私有属性)
        private int i = 11;
        public int value() { return i; }
    }

    protected class PDestination implements Destination { //只有Parcel4及其子类，还有与Parcel4同一个包中的类才能访问PDestination
        private String label;
        private PDestination(String whereTo) {
            label = whereTo;
        }
        public String readLabel() {
            return label;
        }
    }

    public Destination destination(String s) {
        return new PDestination(s);
    }
    public Contents contents() {
        //对于普通类来说，在外部是无法直接访问私有属性的;但是内部类是特例，pc对象处于PContents外部，但是它是可以直接访问私有属性i
        //可以理解为PContents内部类属于Parcel4类的一个私有属性,在Parcel4其内部是可以访问所有的私有属性。
        PContents pc = new PContents();
        int i = pc.i;
        return pc;
    }
}
