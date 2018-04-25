package polymorphism;

/**
* @Description:父类构造器内部调用了子类重写父类的方法(而子类还未被初始化)
* @Author:hxw
* @Date:2018/4/7 19:10
*/
public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
    /*
     Glyph() {
        System.out.println("Glyph() before draw()");
        this.draw();  //程序运行中，这里调用的是RoundGlyph的draw方法(发现这里this指的是RoundGlyph)，如果这里有访问RoundGlyph的成员就会出现问题，因为RoundGlyph还未被初始化
        System.out.println("Glyph() after draw()");
    }
     我们发现，当试图创建RoundGlyph对象时，会首先执行RoundGlyph的父类Glyph的构造器(可以看做子类调用父类的构造器，this指的是RoundGlyph)，而父类构造器中调用了
     已经被子类RoundGlyph覆盖的draw方法，而此时RoundGlyph对象还未被初始化，一旦draw方法里有访问RoundGlyph的成员，由于还未初始化，所有成员都为默认值，肯定会出问题；

    重要
    总结：在构造器内部最好只调用本类的private和final修饰的方法，因为这两种方法不会被子类覆盖，也就不会出现上面的情况了。
    * */
    //
}
