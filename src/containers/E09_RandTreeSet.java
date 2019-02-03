package containers;

import net.mindview.util.CollectionData;
import net.mindview.util.RandomGenerator;

import java.util.TreeSet;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/3 17:00
 */
public class E09_RandTreeSet {

    public static void main(String[] args){
        TreeSet<String> ts = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        CollectionData<String> list = CollectionData.list(new RandomGenerator.String(), 10);
        ts.addAll(list);
        System.out.println("ts = " + ts); //ts = [ahKcxrE, GcFOWZn, GZMmJMR, naMesbt, oEsuEcU, OneOEdL, qUCBbkI, smwHLGE, TcQrGse, YNzbrny]
    }
}
