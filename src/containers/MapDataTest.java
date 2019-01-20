package containers;

import net.mindview.util.CountingGenerator;
import net.mindview.util.MapData;
import net.mindview.util.RandomGenerator;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/20 23:01
 */
public class MapDataTest {

    public static void main(String[] args) {
        // Pair Generator:
        print(MapData.map(new Letters(), 11)); //Letters 实现了Generator接口，还实现了Iterable接口

        // Two separate generators:
        print(
                MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(3), 8)
        );

        // A key Generator and a single value:
        print(
                MapData.map(new CountingGenerator.Character(), "Value", 6)
        );

        // An Iterable and a value Generator:
        print(
                MapData.map(new Letters(), new RandomGenerator.String(3))
        );

        // An Iterable and a single value:
        print(MapData.map(new Letters(), "Pop"));
    }
}
