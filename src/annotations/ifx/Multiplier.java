package annotations.ifx;

/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/30
 */
@ExtractInterface(interfaceName="IMultiplier") //注解被赋予 IMultiplier 的 InterfaceName 作为要创建的接口的名称
public class Multiplier {

    public boolean flag = false;
    private int n = 0;
    public int multiply(int x, int y) {
        int total = 0;
        for(int i = 0; i < x; i++) { //通过不断累加实现乘积
            total = add(total, y);
        }
        return total;
    }

    public int fortySeven() {
        return 47;
    }
    private int add(int x, int y) { //注意add() 是私有方法，因此不能成为接口的一部分
        return x + y;
    }
    public double timesTen(double arg) {
        return arg * 10;
    }

    public static void main(String[] args) {
        Multiplier m = new Multiplier();
        System.out.println("11 * 16 = " + m.multiply(11, 16));
    }

}
