package arrays;

import java.util.Arrays;
import java.util.Comparator;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/16 0:20
 */
public class E24_ArraySearch {

    public static void main(String[] args) {
        //匿名内部类创建Comparator接口，排序规则：比较data的值，小的在前，大的在后
        Comparator<DataHolder> comp = new Comparator<DataHolder>() {
                    public int compare(DataHolder o1, DataHolder o2) {
                        return (o1.data < o2.data ? -1 :
                                (o1.data == o2.data ? 0 : 1));
                    }
                };

        DataHolder[] a = new DataHolderWithEquals[10];
        for(int i = 0; i < a.length; i++){
            a[i] = new DataHolderWithEquals(i);
        }
        Arrays.sort(a, comp);
        int location = Arrays.binarySearch(a, a[7], comp);
        printnb("Location of " + a[7] + " is " + location);
        if(location >= 0){
            print(", a[" + location + "] = " + a[location]);
        } else{
            print();
        }
        location = Arrays.binarySearch(a, a[5], comp);
        printnb("Location of " + a[5] + " is " + location);
        if(location >= 0)
            print(", a[" + location + "] = " + a[location]);
    }
}
