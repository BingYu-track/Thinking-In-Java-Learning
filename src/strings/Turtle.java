package strings;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/6 21:23
 */
public class Turtle {
    private String name;
    private Formatter f;
    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }
    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d,%d)\n", name, x, y);
    }

    public void move(float f){
        this.f.format("%s The Turtle is at (%e)\n",name,f);
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.out;
        Turtle tommy = new Turtle("Tommy", new Formatter(System.out));
        Turtle terry = new Turtle("Terry", new Formatter(outAlias));
        tommy.move(0,0);
        terry.move(4,8);
        tommy.move(3,4);
        terry.move(2,5);
        tommy.move(3,3);
        terry.move(3,3);
        terry.move(0.0000034456f); //Terry The Turtle is at (3.445600e-06)
    }
}
