package polymorphism;

public class RectangularGlyph extends Glyph{

    private int width = 4;
    private int height = 5;
    RectangularGlyph(int width, int height) {
        this.width = width;
        this.height = height;
        System.out.println("RectangularGlyph.RectangularGlyph(), width = " + width + ", height = " + height);
    }
    void draw() {
        System.out.println("RectangularGlyph.draw(), area = " + width * height);
    }
}
