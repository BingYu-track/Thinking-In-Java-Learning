package containers;
import static net.mindview.util.Countries.*;

import java.util.*;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/28 22:35
 */
public class E01_CountryList {

    private static Random rnd = new Random(47);
    public static void main(String[] args) {
        //List<String> l = new ArrayList<String>(names(8));
        List<String> l = new LinkedList<String>(names(8));
        Collections.sort(l); //根据元素的自然顺序排列
        print("sorted: " + l);
        for(int i = 1; i < 5; i++) {
            Collections.shuffle(l, rnd); //随机排列指定列表使用指定的随机源。
            print("shuffled (" + i + "): " + l);
        }
    }
}
