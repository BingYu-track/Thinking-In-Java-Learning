package containers;

import net.mindview.util.CollectionData;
import net.mindview.util.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/20 18:29
 */
public class CollectionDataGeneration {

    public static void main(String[] args) {
        System.out.println(new ArrayList<String>(
                CollectionData.list(new RandomGenerator.String(9), 10)) //new RandomGenerator.String(9)中的9是控制字符串的长度
        );
        System.out.println(new HashSet<Integer>(
                new CollectionData<Integer>(new RandomGenerator.Integer(), 10))
        );
    }
}
