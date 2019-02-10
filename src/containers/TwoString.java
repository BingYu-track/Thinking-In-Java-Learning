package containers;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;
import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/10 14:35
 */
public class TwoString implements Comparable<TwoString>{

    String s1, s2;
    public TwoString(String s1i, String s2i) {
        s1 = s1i;
        s2 = s2i;
    }
    public String toString() {
        return "[s1 = " + s1 + ", s2 = " + s2 + "]";
    }
    public int compareTo(TwoString rv) {
        String rvi = rv.s1;
        return s1.compareTo(rvi);
    }
    private static RandomGenerator.String gen = new RandomGenerator.String();

    public static Generator<TwoString> generator() {
        return new Generator<TwoString>() {
            public TwoString next() {
                return new TwoString(gen.next(), gen.next());
            }
        };
    }

}
