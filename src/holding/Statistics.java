package holding;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/6/24 21:17
 */
public class Statistics {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i = 0; i < 10000; i++) {
        // 随机产生一个0到20的数
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            //在map记录相同数出现的次数
            m.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(m);
    }
}
