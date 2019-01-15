package arrays;

import java.util.Comparator;

/**
 * @version 1.0
 * @Description: 自定义比较器(基于j值比较)
 * @author: hxw
 * @date: 2019/1/15 8:35
 */
public class CompTypeComparator implements Comparator<CompType> {
    public int compare(CompType o1, CompType o2) {
        return (o1.j < o2.j ? -1 : (o1.j == o2.j ? 0 : 1));
    }
}
