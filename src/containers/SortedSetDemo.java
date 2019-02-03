package containers;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description: SortedSet
 * @author: hxw
 * @date: 2019/2/3 13:24
 */
public class SortedSetDemo {

    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<String>();
        Collections.addAll(
                sortedSet, "one two three four five six seven eight".split(" ")
        );
        print(sortedSet); //[eight, five, four, one, seven, six, three, two]
        String low = sortedSet.first();
        String high = sortedSet.last();
        print(low); //eight
        print(high); //two
        Iterator<String> it = sortedSet.iterator();
        for(int i = 0; i <= 6; i++) {
            if(i == 3)
                low = it.next();
            if(i == 6)
                high = it.next();
            else
                it.next();
        }
        print(low); //one
        print(high); //two
        print(sortedSet.subSet(low, high)); //[one, seven, six, three]
        print(sortedSet.headSet(high)); //[eight, five, four, one, seven, six, three]
        print(sortedSet.tailSet(low)); //[one, seven, six, three, two]
    }
}
