package containers;

import net.mindview.util.Countries;

import java.util.HashMap;
import java.util.Map;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description: hashMap加载因子
 * @author: hxw
 * @date: 2019/2/9 23:26
 */
public class E38_HashMapLoadFactor {

    public static void testGet(Map<String,String> filledMap, int n) {
        for(int tc = 0; tc < 1000000; tc++){ //总共要执行 1000000*195次查询
            for(int i = 0; i < Countries.DATA.length; i++) {
                String key = Countries.DATA[i][0];
                filledMap.get(key);
            }
        }

    }

    public static void main(String args[]) {
        // Initial capacity 16:默认容量为16 map1
        HashMap<String,String> map1 = new HashMap<String,String>();
        // Fill to less than threshold: 填充小于阈值
        map1.putAll(Countries.capitals(11));
        // Initial capacity 32: 初始化容量为32的map2
        HashMap<String,String> map2 = new HashMap<String,String>(32);
        map2.putAll(map1);
        long t1 = System.currentTimeMillis();
        testGet(map1, 11); //测试map1
        long t2 = System.currentTimeMillis();
        print("map1 : " + (t2 - t1));
        t1 = System.currentTimeMillis();
        testGet(map2, 11); //测试map2
        t2 = System.currentTimeMillis();
        print("map2 : " + (t2 - t1));
    }
}
