package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/24 14:13
 */
public class E04_GenericSequence {

    public static void main(String[] args) {
        Sequence<String> sequence = new Sequence<String>(10);
        for(int i = 0; i < 10; i++){
            sequence.add(Integer.toString(i));
        }

        Selector<String> selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }

    }
}
