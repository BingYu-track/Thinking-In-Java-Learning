package containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description: 覆写hashCode示例
 * @author: hxw
 * @date: 2019/2/8 2:06
 */
public class CountedString {

    private static List<String> created = new ArrayList<String>();
    private String s;
    private int id = 0;

    public CountedString(String str) {
        s = str;
        created.add(s);
        // id is the total number of instances of this string in use by CountedString:id是CountedString使用的此字符串的实例总数：
        for(String s2 : created){
            if(s2.equals(s))
                id++;
        }
    }

    public String toString() {
        return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
    }

    public int hashCode() {
        // The very simple approach: return s.hashCode() * id; Using Joshua Bloch’s recipe:非常简单的方法：返回s.hashCode()*id；使用约书亚·布洛赫的配方：
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }

    public boolean equals(Object o) { //字符串和id都相等
        return o instanceof CountedString &&
                s.equals(((CountedString)o).s) &&
                id == ((CountedString)o).id;
    }

    public static void main(String[] args) {
        Map<CountedString,Integer> map = new HashMap<CountedString,Integer>();
        CountedString[] cs = new CountedString[5];
        for(int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i); // Autobox int -> Integer
        }
        print(map);
        for(CountedString cstring : cs) {
            print("Looking up " + cstring);
            print(map.get(cstring));
        }
    }


}
