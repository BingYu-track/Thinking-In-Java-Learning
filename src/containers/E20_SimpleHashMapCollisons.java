package containers;

import net.mindview.util.Countries;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/8 0:16
 */
public class E20_SimpleHashMapCollisons {

    public static void main(String[] args) {
        SimpleHashMap2<String,String> m = new SimpleHashMap2<String,String>();
        m.putAll(Countries.capitals(25));
        System.out.println("---------------我是分界线--------------");
        m.putAll(Countries.capitals(25));
        System.out.println(m);
        System.out.println(m.get("THE GAMBIA"));
    }
}
