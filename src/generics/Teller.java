package generics;

import net.mindview.util.Generator;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/10/6 18:25
 */
class Teller {

    private static long counter = 1;
    private final long id = counter++;
    private Teller() {}
    public String toString() { return "Teller " + id; }
    // A single Generator object:
    public static Generator<Teller> generator = new Generator<Teller>() {
                public Teller next() { return new Teller(); }
            };
}
