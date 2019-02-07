package containers;

import net.mindview.util.Countries;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/8 0:32
 */
public class E22_SimpleHashMapClearRemove {

    public static void main(String[] args) {
        SimpleHashMap3<String,String> m = new SimpleHashMap3<String,String>();
        m.putAll(Countries.capitals(10));
        System.out.println(m);
        System.out.println("m.get(\"BURUNDI\") = " + m.get("BURUNDI"));
        m.remove("BURUNDI");
        System.out.println("After removal, m.get(\"BURUNDI\") = " + m.get("BURUNDI"));
        m.clear();
        System.out.println("After clearing: " + m);
    }

}
