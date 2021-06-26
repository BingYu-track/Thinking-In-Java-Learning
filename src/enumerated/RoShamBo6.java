package enumerated;
import static enumerated.Outcome.*;
/**
 * @version 1.0
 * @Description: Enum使用二维数组进行分发
 * @author: bingyu
 * @date: 2021/6/26
 */
public enum RoShamBo6 implements Competitor<RoShamBo6>{

    PAPER, SCISSORS, ROCK;
    private static Outcome[][] table = {
            //(因为PAPER次序已经固定了，这里它的顺序不能随便动，只能在第一行)
            { DRAW/*和PAPER比较的结果值*/, LOSE/*和SCISSORS比较的结果值*/, WIN/*和ROCK比较的结果值*/ }, //PAPER
            { WIN/*和PAPER比较的结果值*/, DRAW/*和SCISSORS比较的结果值*/, LOSE/*和ROCK比较的结果值*/ }, // SCISSORS
            { LOSE/*和PAPER比较的结果值*/, WIN/*和SCISSORS比较的结果值*/, DRAW/*和ROCK比较的结果值*/ }, // ROCK
    };
    public Outcome compete(RoShamBo6 other) {
        return table[this.ordinal()][other.ordinal()]; //this.ordinal()是当前枚举实例的次序;other.ordinal()是竞争目标枚举实例所在的次序
    }
    public static void main(String[] args) {
        RoShamBo.play(RoShamBo6.class, 20);
    }
}
