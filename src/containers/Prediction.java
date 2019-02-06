package containers;

import java.util.Random;

/**
 * @version 1.0
 * @Description: 天气预测，预报
 * @author: hxw
 * @date: 2019/2/6 18:34
 */
public class Prediction {

    private static Random rand = new Random(47);
    private boolean shadow = rand.nextDouble() > 0.5;
    public String toString() {
        if(shadow)
            return "Six more weeks of Winter!"; //再过六周就到冬天
        else
            return "Early Spring!"; //早春
    }
}
