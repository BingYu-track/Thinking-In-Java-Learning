package arrays;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;
import net.mindview.util.ConvertTo;
import net.mindview.util.Generated;
import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;
import static net.mindview.util.Print.*;
import java.util.Arrays;

/**
 * @version 1.0
 * @Description: 在未排序的数组上执行binarySearch
 * @author: hxw
 * @date: 2019/1/15 23:58
 */
public class E22_ArrayBinarySearch {

    public static void main(String[] args) {
        Generator<Integer> gen = new RandomGenerator.Integer(1000);
        int[] a = ConvertTo.primitive(Generated.array(new Integer[25], gen));
        print("Unsorted array: " + Arrays.toString(a));//Unsorted array: [258, 555, 693, 861, 961, 429, 868, 200, 522, 207, 288, 128, 551, 589, 809, 278, 998, 861, 520, 258, 916, 140, 511, 322, 704]
        int location = Arrays.binarySearch(a, a[10]);
        printnb("Location of " + a[10] + " is " + location); //Location of 288 is -2
        if(location >= 0){
            print(", a[" + location + "] = " + a[location]);
        } else{
            print();
        }
        location = Arrays.binarySearch(a, a[5]);
        printnb("Location of " + a[5] + " is " + location);//Location of 429 is 5
        if(location >= 0){
            print(", a[" + location + "] = " + a[location]);
        }
    }
    //显然，您不能信任未排序数组的二进制搜索。我们的搜索找到了第六个元素，但没有找到第11个元素。
}
