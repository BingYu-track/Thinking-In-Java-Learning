package containers;

import net.mindview.util.Countries;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/10 0:08
 */
public class E39_SimpleHashMapRehash {

    public static void main(String[] args) {
        SimpleHashMap7<String,String> m = new SimpleHashMap7<String,String>();
        m.putAll(Countries.capitals(50));
        System.out.println(m);
    }

}
