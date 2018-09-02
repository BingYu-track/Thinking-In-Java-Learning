package innerclasses;

public class Parcel4 {

    private class PContents implements Contents {
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
        return new PContents();
    }
}
