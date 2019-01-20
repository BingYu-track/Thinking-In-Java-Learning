package containers;

import net.mindview.util.CollectionData;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/20 18:18
 */
public class CollectionDataTest {

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>(new CollectionData<String>(new Government(), 15)); //Government是一个生产器
        // Using the convenience method:
        set.addAll(CollectionData.list(new Government(), 15));
        System.out.println(set);
    }
}
