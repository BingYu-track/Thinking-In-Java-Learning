package enumerated.cartoons;
import java.util.*;
import net.mindview.util.*;

/**
 * @version 1.0
 * @Description: 实现，而非继承
 * @author: bingyu
 * @date: 2021/6/23
 */
enum CartoonCharacter implements Generator<CartoonCharacter>{
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private Random rand = new Random(47);

    @Override
    public CartoonCharacter next() {
        int i = rand.nextInt(values().length); //根据枚举实例数随机获取数字
        return values()[i]; //再根据数字获取枚举实例
    }

}
