package containers;

import net.mindview.util.Countries;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/8 0:43
 */
public class E23_FullSimpleHashMap {

    public static void main(String args[]) {
        SimpleHashMap4<String,String> m = new SimpleHashMap4<String,String>(),
                m2 = new SimpleHashMap4<String,String>();
        m.putAll(Countries.capitals(10));
        m2.putAll(Countries.capitals(10));
        print("m.size() = " + m.size());
        print("m.isEmpty() = " + m.isEmpty());
        print("m.equals(m2) = " + m.equals(m2));
        print("m.containsKey(\"BENIN\") = " + m.containsKey("BENIN"));
        print("m.containsKey(\"MARS\") = " + m.containsKey("MARS"));
        print("m.keySet() = " + m.keySet());
        print("m.values() = " + m.values());
    }
}
