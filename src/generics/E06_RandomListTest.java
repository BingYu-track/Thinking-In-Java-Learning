package generics;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;
import net.mindview.util.CountingGenerator;
import net.mindview.util.Generator;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/24 22:22
 */
public class E06_RandomListTest {

    private static void dump(RandomList<?> rl) {
        for(int i = 0; i < 11; i++)
            System.out.print(rl.select() + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<String>();
        for(String s: ("The quick brown fox jumped over " + "the lazy brown dog").split(" ")){
            rs.add(s);
        }
        dump(rs);
        RandomList<Integer> ri = new RandomList<Integer>();
        Generator<Integer> gi = new CountingGenerator.Integer();
        for(int i = 0; i < 11; i ++){
            ri.add(gi.next());
        }
        dump(ri);
        RandomList<Character> rc = new RandomList<Character>();
        Generator<Character> gc = new CountingGenerator.Character();
        for(int i = 0; i < 11; i ++)
            rc.add(gc.next());
        dump(rc);
    }
    /*
    我们使用生成器接口和计数生成器类分别生成整数序列和字符序列。稍后您将在TIJ 4中了解更多有关这些信息的内容。
    注意dump()方法的参数类型：RandomList<？>接受任何具有未知类型参数化的RandomList。
    **/
}
