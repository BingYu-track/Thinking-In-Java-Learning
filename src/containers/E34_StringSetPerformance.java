package containers;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;
import net.mindview.util.CountingGenerator;
import net.mindview.util.Generator;

import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/8 22:07
 */
public class E34_StringSetPerformance {

    static List<Test<Set<String>>> tests =
            new ArrayList<Test<Set<String>>>();
    static {

        tests.add(new Test<Set<String>>("add") {
            int test(Set<String> set, TestParam tp) {
                Generator<String> gen;
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    set.clear();
                // Always starts the sequence from the beginning.
                    gen = new CountingGenerator.String();
                    for (int j = 0; j < size; j++)
                        set.add(gen.next());
                }
                return loops * size;
            }
        });

        tests.add(new Test<Set<String>>("contains") {
            int test(Set<String> set, TestParam tp) {
                Generator<String> gen =
                        new CountingGenerator.String(5);
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++)
                    for (int j = 0; j < span; j++)
                        set.contains(gen.next());
                return loops * span;
            }
        });

        tests.add(new Test<Set<String>>("iterate") {
            int test(Set<String> set, TestParam tp) {
                int loops = tp.loops * 10;
                for(int i = 0; i < loops; i++) {
                    Iterator<String> it = set.iterator();
                    while(it.hasNext())
                        it.next();
                }
                return loops * set.size();
            }
        });

    }

    public static void main(String[] args) {
        if(args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        Tester.fieldWidth = 10;
        Tester.run(new TreeSet<String>(), tests);
        Tester.run(new HashSet<String>(), tests);
        Tester.run(new LinkedHashSet<String>(), tests);
    }
}
