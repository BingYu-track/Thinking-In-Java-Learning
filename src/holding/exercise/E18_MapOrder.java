package holding.exercise;

import net.mindview.util.Countries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/6/24 23:34
 */
public class E18_MapOrder {

    public static void main(String[] args){
        Map<String,String> m1 = new HashMap<String,String>(Countries.capitals(25));
        System.out.println(m1);
        String[] keys = m1.keySet().toArray(new String[0]); //返回一个包含此 set 中所有元素的数组；返回数组的运行时类型是指定数组的类型
        Arrays.sort(keys);
        Map<String,String> m2 = new LinkedHashMap<String,String>();
        for(String key : keys){
            m2.put(key, m1.get(key));
        }
        System.out.println(m2);
    }
}
