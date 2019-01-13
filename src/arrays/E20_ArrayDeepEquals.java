package arrays;

import org.junit.Test;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description: 多维数组的比较
 * @author: hxw
 * @date: 2019/1/13 22:58
 */
public class E20_ArrayDeepEquals {

    public static void main(String[] args){
        int[][] table1 = {
                            {1, 2, 3},
                            {4, 5},
                            {7, 8, 9, 10}
                        };
        int[][] table2 = {
                            {1, 2, 3},
                            {4, 5},
                            {7, 8, 9, 10}
                        };
        Integer[][] table3 = {
                                {1, 2, 3},
                                {4, 5},
                                {7, 8, 9, 10}
                             };
        int[][] table4 = {
                            {1, 2, 3},
                            {6, 5, 4},
                            {7, 8}
                        };
        System.out.println(Arrays.deepEquals(table1, table2));
        System.out.println(Arrays.deepEquals(table1, table3));
        System.out.println(Arrays.deepEquals(table1, table4));
        // Let us check manually for equality between table1 and table3
        boolean res = true;
        exit_loop: //java的标签机制
        for(int i = 0; i < table1.length; i++)
            for(int j = 0; j < table1[i].length; j++)
                if(table1[i][j] != table4[i][j]) {
                    res = false;
                    break exit_loop; //打断所有循环，直接跳转到exit_loop:位置
                }
        System.out.println(res);
    }
    /*
        尽管表1和表3在语义上是相同的，但是编译器认为它们是不同的(因为数组)，但arrays.深处Equals()并不报告表1和表3相等。
        但是，当我们“手动”比较这两个数组时，透明的自动装箱会产生所需的结果。
    */

}
