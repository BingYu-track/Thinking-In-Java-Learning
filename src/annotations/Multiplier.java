package annotations;

/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/28
 */
@ExtractInterface("IMultiplier")
public class Multiplier {

    /**
     * 使用加法实现乘法
     * @param x 执行的次数
     * @param y 增加的数量
     * @return
     */
    public int multiply(int x, int y) {
        int total = 0;
        for(int i = 0; i < x; i++) {
            total = add(total, y);
        }
        return total;
    }

    private int add(int x, int y) {
        return x + y;
    }
    public static void main(String[] args) {
        Multiplier m = new Multiplier();
        System.out.println("11*16 = " + m.multiply(11, 16));
    }

}
