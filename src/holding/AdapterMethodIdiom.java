package holding;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/5 8:43
 */
public class AdapterMethodIdiom {
    public static void main(String[] args) {
        ReversibleArrayList<String> ral = new ReversibleArrayList<String>(
                        Arrays.asList("To be or not to be".split(" ")));
        // 通过iterator()获取普通迭代器
        for(String s : ral){
            System.out.print(s + " ");
        }
        System.out.println();
        // Hand it the Iterable of your choice
        for(String s : ral.reversed()){
            System.out.print(s + " ");
        }
    }
}
