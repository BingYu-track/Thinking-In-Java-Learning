package holding.exercise;

import net.mindview.util.Countries;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/1 19:55
 */
public class E24_MapOrder2 {

    public static void main(String[] args){
        Map<String,String> m1 = new LinkedHashMap<String,String>(Countries.capitals(25));
        System.out.println(m1);
        String[] keys = m1.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        Map<String,String> m2 = new LinkedHashMap<String,String>();
        for(String key : keys){
            m2.put(key, m1.get(key));
        }
        System.out.println(m2);
    }
}
