package innerclasses;


public class Parcel8 {

    public Wrapping wrapping(int x) {
        // Base constructor call:
        return new Wrapping(x) { //由于Wrapping不是接口而是类，因此这里相当于创建了一个继承Wrapping的匿名内部类对象 Pass constructor argument.
            public int value() {
                return super.value() * 47; //这里super指的是Wrapping
            }
        }; // Semicolon required
    }
    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10); //这里返回的对象是继承了Wrapping的匿名内部类对象
        int value = w.value();
    }
}
