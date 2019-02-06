package containers;

import java.util.Map;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/6 20:19
 */
public class E16_SlowMapTest {

    public static void printKeys(Map<Integer,String> map) {
        printnb("Size = " + map.size() + ", ");
        printnb("Keys: ");
        print(map.keySet()); // Produce a Set of the keys
    }

    public static void test(Map<Integer,String> map) {
        print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        // Map has 'Set' behavior for keys:
        map.putAll(new CountingMapData(25));
        printKeys(map);
        // Producing a Collection of the values:
        printnb("Values: ");
        print(map.values());
        print(map);
        print("map.containsKey(11): " + map.containsKey(11));
        print("map.get(11): " + map.get(11));
        print("map.containsValue(\"F0\"): " + map.containsValue("F0"));
        Integer key = map.keySet().iterator().next();
        print("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        print("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(25));
        // Operations on the Set change the Map:
        map.keySet().removeAll(map.keySet());
        print("map.isEmpty(): " + map.isEmpty());
    }

    public static void main(String[] args) {
        System.out.println("Testing SlowMap");
        test(new SlowMap<Integer,String>());
        System.out.println("Testing SlowMap2");
        test(new SlowMap2<Integer,String>());
    }
}
/*
正如JDK中所述，entrySet()应该返回映射中包含的映射的集合视图。SlowMap中的entrySet()方法每次调用都会返回一个新的键-值set副本，而SlowMap中调用remove()和isEmpty()方法中
都会调用一次entrySet()方法返回一个新的键-值Set，因此导致remove()方法和map.clear()方法无效，因为他们操作的压根就不是同一个Set<Map.Entry>对象，即集合上的操作不会更改映射。
SlowMap2类修复了这个问题；请参见输出中的差异。

Testing SlowMap
SlowMap
Size = 25,
Keys:
[6, 0, 2, 4, 8, 10, 12, 14, 17, 19, 21, 23, 7, 1, 3, 5, 9, 11, 13, 15, 16, 18, 20, 22, 24]
Values:
[G0, A0, C0, E0, I0, K0, M0, O0, R0, T0, V0, X0, H0, B0, D0, F0, J0, L0, N0, P0, Q0, S0, U0, W0, Y0]
{6=G0, 0=A0, 2=C0, 4=E0, 8=I0, 10=K0, 12=M0, 14=O0, 17=R0, 19=T0, 21=V0, 23=X0, 7=H0, 1=B0, 3=D0, 5=F0, 9=J0, 11=L0, 13=N0, 15=P0, 18=S0, 20=U0, 22=W0, 24=Y0, 16=Q0}
map.containsKey(11): true
map.get(11): L0
map.containsValue("F0"): true
First key in map: 6
Size = 25,
Keys:
[6, 0, 2, 4, 8, 10, 12, 14, 17, 19, 21, 23, 7, 1, 3, 5, 9, 11, 13, 15, 18, 20, 22, 24, 16]
map.isEmpty(): false
map.isEmpty(): false

Testing SlowMap2
SlowMap2
Size = 25,
Keys:
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
Values:
[A0, B0, C0, D0, E0, F0, G0, H0, I0, J0, K0, L0, M0, N0, O0, P0, Q0, R0, S0, T0, U0, V0, W0, X0, Y0]
{0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0, 10=K0, 11=L0, 12=M0, 13=N0, 14=O0, 15=P0, 16=Q0, 17=R0, 18=S0, 19=T0, 20=U0, 21=V0, 22=W0, 23=X0, 24=Y0}
map.containsKey(11): true
map.get(11): L0
map.containsValue("F0"): true
First key in map: 0
Size = 24,
Keys:
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
map.isEmpty(): true
map.isEmpty(): true
*/
