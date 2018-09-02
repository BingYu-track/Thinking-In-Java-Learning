package innerclasses;

public class Parcel2 {
    //内部类
    class Contents {
        private int i = 11;
        public int value() { return i; }
    }

    //内部类
    class Destination {
        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }
        String readLabel() { return label; }
    }

    public Destination to(String s) {
        return new Destination(s);
    }
    public Contents contents() {
        return new Contents(); //在非静态方法，创建内部类对象与使用普通类没什么区别
    }
    public void ship(String dest) {
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }
    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("Tasmania");
        Parcel2 q = new Parcel2();
        // Defining references to inner classes:
        q.contents();
        //Parcel2.Contents c = new Contents(); 编译器报错
        /*在静态的方法中是不能直接创建内部类对象的，内部类有一个重要特性，就是可以访问外部类的成员变量，既然是这样，那外部类就必须实例化。
        但是在静态方法中，是可以不用new外部类的实例对象就可以运行,所以这就造成了矛盾。*/
        Parcel2.Destination d = q.to("Borneo"); //使用非静态方法来返回内部类对象
    }

}
