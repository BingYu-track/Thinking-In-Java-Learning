package polymorphism;

public class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }
    Glyph() {
        System.out.println("Glyph() before draw()");
        this.draw();  //程序运行中，这里调用的是RoundGlyph的draw方法，如果这里有访问RoundGlyph的成员就会出现问题，因为RoundGlyph还未被初始化
        System.out.println("Glyph() after draw()");
    }
}
