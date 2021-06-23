package enumerated;

import java.util.Random;

/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/23
 */
enum CartoonCharacter {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private static Random rand = new Random(47);

    //这里是使用的static方法，好处是不用再创建实例调用next()方法
    //坏处是使用Generator的方法不能再接收CartoonCharacter????
    public static CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}
