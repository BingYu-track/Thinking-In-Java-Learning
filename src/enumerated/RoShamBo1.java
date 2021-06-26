package enumerated;
import java.util.*;
import static enumerated.Outcome.*;

interface Item { //定义了3个eval方法
    Outcome compete(Item it);
    Outcome eval(Paper p);
    Outcome eval(Scissors s);
    Outcome eval(Rock r);
}

class Paper implements Item {
    public Outcome compete(Item it) {
        return it.eval(this);
    }
    public Outcome eval(Paper p) {
        return DRAW;
    }
    public Outcome eval(Scissors s) {
        return WIN;
    }
    public Outcome eval(Rock r) {
        return LOSE;
    }
    public String toString() {
        return "Paper";
    }
}

class Scissors implements Item {
    public Outcome compete(Item it) {
        return it.eval(this);
    }
    public Outcome eval(Paper p) {
        return LOSE;
    }
    public Outcome eval(Scissors s) {
        return DRAW;
    }
    public Outcome eval(Rock r) {
        return WIN;
    }
    public String toString() {
        return "Scissors";
    }
}

class Rock implements Item {
    public Outcome compete(Item it) {
        return it.eval(this);
    }
    public Outcome eval(Paper p) {
        return WIN;
    }
    public Outcome eval(Scissors s) {
        return LOSE;
    }
    public Outcome eval(Rock r) {
        return DRAW;
    }
    public String toString() {
        return "Rock";
    }
}

/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/26
 */
public class RoShamBo1 {
    static final int SIZE = 20;
    private static Random rand = new Random(47);

    //随机返回一个
    public static Item newItem() {
        switch(rand.nextInt(3)) {
            default:
            case 0: return new Scissors();
            case 1: return new Paper();
            case 2: return new Rock();
        }
    }
    public static void match(Item a, Item b) {
        System.out.println(a + " vs. " + b + ": " + a.compete(b));
    }
    public static void main(String[] args) {
        for(int i = 0; i < SIZE; i++) {
            match(newItem(), newItem());
        }
    }



}
