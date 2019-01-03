package arrays;

import net.mindview.util.CountingGenerator;
import net.mindview.util.Generator;
import org.junit.Test;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/3 23:40
 */
public class GeneratorsTest{

    public static int size = 10;

    public static void test(Class<?> surroundingClass) {
        for(Class<?> type : surroundingClass.getClasses()) { //遍历公共的内部类
            System.out.print(type.getSimpleName() + ": ");
            try {
                Generator<?> g = (Generator<?>)type.newInstance();
                for(int i = 0; i < size; i++)
                    System.out.printf(g.next() + " ");
                System.out.println();
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args){
        test(CountingGenerator.class);
    }

    @Test
    public void test1() {
        int i = 0;
        CountingGenerator.Character character = new CountingGenerator.Character();
        while ( i < 100){
            System.out.print(character.next()+",");
            i++;
        }
    }


}
