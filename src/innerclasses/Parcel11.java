package innerclasses;

public class Parcel11 {

    private static class ParcelContents implements Contents {
        private int i = 11;
        public int value() { return i; }
    }
    protected static class ParcelDestination implements Destination {
        private String label;
        private ParcelDestination(String whereTo) { //私有构造
            label = whereTo;
        }
        public String readLabel() { return label; }
        //嵌套类可以包含其它静态元素 Nested classes can contain other static elements:
        public static void f() { //静态方法
        }
        static int x = 10; //静态成员
        static class AnotherLevel {   //嵌套类
            public static void f() {}
            static int x = 10;
        }
    }

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }
    public static Contents contents() {
        return new ParcelContents();
    }
    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tasmania");
    }
}
