package generics;

import net.mindview.util.BasicGenerator;
import net.mindview.util.Generator;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/10/5 22:28
 */
public class BasicGeneratorDemo {

    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for(int i = 0; i < 5; i++)
            System.out.println(gen.next());
    }
}
