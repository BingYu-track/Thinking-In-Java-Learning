package containers;

import java.util.HashMap;
import java.util.Map;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/8 2:45
 */
public class E26_CountedString2 {

    public static void main(String[] args) {
        Map<CountedString2,Integer> map = new HashMap<CountedString2,Integer>();
        CountedString2[] cs = new CountedString2[5];
        for(int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString2("hi", 'c');
            map.put(cs[i], i); // Autobox int -> Integer
        }

        print(map);
        for(CountedString2 cstring : cs) {
            print("Looking up " + cstring);
            print(map.get(cstring));
        }

    }


}
