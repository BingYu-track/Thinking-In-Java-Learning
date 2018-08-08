package strings.exercise;

import strings.Splitting;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/8 7:51
 */
public class E08_Splitting2 {
    public static void split(String regex) {
        System.out.println(Arrays.toString(Splitting.knights.split(regex)));
    }
    public static void main(String[] args) {
        split("the|you");
    }
}
