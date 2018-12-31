package arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/31 19:31
 */
public class IceCream {

    private static Random rand = new Random(47);
    static final String[] FLAVORS = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
            "Praline Cream", "Mud Pie"
    };
    public static String[] flavorSet(int n) {
        if(n > FLAVORS.length){
            throw new IllegalArgumentException("Set too big");
        }
        String[] results = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];
        for(int i = 0; i < n; i++) {
            int t;
            do{
                t = rand.nextInt(FLAVORS.length);
            } while(picked[t]); //确保随机生成数所对应的元素没有没有被使用过，否则picked[t]一直为true，一直随机取数
            results[i] = FLAVORS[t];
            picked[t] = true;
        }
        return results;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 7; i++)
            System.out.println(Arrays.toString(flavorSet(3)));
    }
}
