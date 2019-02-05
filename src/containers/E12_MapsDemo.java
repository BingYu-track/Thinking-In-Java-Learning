package containers;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/5 19:53
 */
public class E12_MapsDemo {

    private static void test(Map<String, String> map) {
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        } catch(ArrayIndexOutOfBoundsException e) {
        // Never happen!
            print("Too many objects!");
        }
        print(map);
        print(map.get("ocean"));
    }

    public static void main(String[] args) {
        test(new HashMap<String, String>());
        test(new TreeMap<String, String>());
        test(new LinkedHashMap<String, String>());
    }
}
