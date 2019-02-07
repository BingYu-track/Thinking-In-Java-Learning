package containers;

import java.util.HashMap;
import java.util.Map;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/8 2:49
 */
public class E27_CountedString3 {

    public static void main(String[] args) {
        Map<CountedString3,Integer> map = new HashMap<CountedString3,Integer>();
        CountedString3[] cs = new CountedString3[5];
        for(int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString3("hi");
            map.put(cs[i], i); // Autobox int -> Integer
        }
        for(CountedString3 cstring : cs) {
            print("Looking up " + cstring);
            print(map.get(cstring));
        }
    }
}
