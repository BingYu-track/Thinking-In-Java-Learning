package innerclasses;

public class Parcel9 {

    private String jk = "122";

    public Destination destination(/*final*/ String dest) {
        //注意：匿名内部类在使用传过来的引用参数时， 编译器会要求其参数引用是final的，否则报错。现在jdk1.8会把它默认设置为final的
        //dest = "78";
        return new Destination() {
            private String label = dest; //提示错误:变量是从内部类访问的，需要是final修饰的
            public String readLabel() {
                return label;
            }
        };
    }

    public Destination destination2(/*final*/ String dest) {
        //注意：当匿名内部类没在使用引用参数时，该参数可以不为final
        dest = "78";
        return new Destination() {
            private String label = "123";
            public String readLabel() {
                return label;
            }
        };
    }


    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
        String s = d.readLabel();
        System.out.println();
    }
}
