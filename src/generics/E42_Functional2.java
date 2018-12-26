package generics;

import java.util.Arrays;
import java.util.List;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/26 22:58
 */
public class E42_Functional2 {

    // To use the above generic methods, we need to create
    // function objects to adapt to our particular needs:
    static class Incrementor implements UnaryFunction<DataManipulator1,DataManipulator1> {
        public DataManipulator1 function(DataManipulator1 x) {
            x.increment();
            return x;
        }
    }

    static class UpperCaseConverter implements UnaryFunction<String,DataManipulator2> {
        public String function(DataManipulator2 x) {
            return x.getValue().toUpperCase();
        }
    }

    static class Concatenator implements Combiner<DataManipulator2> {
        public DataManipulator2
        combine(DataManipulator2 x,DataManipulator2 y) {
            x.setValue(x.getValue() + y.getValue());
            return x;
        }
    }

    public static void main(String[] args) {
        DataManipulator1 rf = new DataManipulator1(4);
        List<DataManipulator1> ldm1 = Arrays.asList(new DataManipulator1(3), new DataManipulator1(10),
                                                    new DataManipulator1(1),new DataManipulator1(7));
        print(
                Functional.transform(
                        Functional.filter(ldm1, new Functional.GreaterThan<DataManipulator1>(rf)),
                        new Incrementor()
                )
        );
        List<DataManipulator2> ldm2 = Arrays.asList(
                new DataManipulator2("a"), new DataManipulator2("B"),
                new DataManipulator2("c"),new DataManipulator2("d"));
        print(
                Functional.transform(ldm2, new UpperCaseConverter()));
        print(Functional.reduce(ldm2,
                new Concatenator()).getValue());
    }
}
