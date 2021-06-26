package enumerated;

import java.util.Random;

/**
 * @version 1.0
 * @Description: 用Input枚举定义了贩卖机的各自输入指令
 * @author: bingyu
 * @date: 2021/6/25
 */
public enum Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION { //终止交易
        public int amount() { // Disallow
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP { // This must be the last instance.
        public int amount() { // Disallow
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };
    int value; // In cents
    Input(int value) { this.value = value; }
    Input() {}
    int amount() { return value; }; // In cents 这个amount方法其实是为除ABORT_TRANSACTION和STOP之外的枚举实例准备的，因此这2个枚举实例只能抛异常
    static Random rand = new Random(47);
    public static Input randomSelection() { //随机选取一个输入指令(但是不包括Stop)返回
    // Don’t include STOP:
        return values()[rand.nextInt(values().length - 1)];
    }
}
