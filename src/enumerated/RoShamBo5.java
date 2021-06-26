package enumerated;
import java.util.*;
import static enumerated.Outcome.*;
/**
 * @version 1.0
 * @Description: EnumMap实现多路分发
 * @author: bingyu
 * @date: 2021/6/26
 */
public enum RoShamBo5 implements Competitor<RoShamBo5>{

    PAPER, SCISSORS, ROCK;
    static EnumMap<RoShamBo5,EnumMap<RoShamBo5,Outcome>> table = new EnumMap<RoShamBo5, EnumMap<RoShamBo5,Outcome>>(RoShamBo5.class);

    static {
        for(RoShamBo5 it : RoShamBo5.values()){
            table.put(it, new EnumMap<RoShamBo5,Outcome>(RoShamBo5.class));
        }
        initRow(PAPER, DRAW, LOSE, WIN);
        initRow(SCISSORS, WIN, DRAW, LOSE);
        initRow(ROCK, LOSE, WIN, DRAW);
    }

    /**
     * 将每个枚举实例与其它枚举比较的结果值，都存储到EnumMap里并进行了对应的映射
     * @param it 当前枚举实例
     * @param vPAPER  和paper比较的结果值
     * @param vSCISSORS 和scissors比较的结果值
     * @param vROCK 和rock比较的结果值
     */
    static void initRow(RoShamBo5 it, Outcome vPAPER, Outcome vSCISSORS, Outcome vROCK) {
        EnumMap<RoShamBo5,Outcome> row = RoShamBo5.table.get(it); //
        row.put(RoShamBo5.PAPER, vPAPER);
        row.put(RoShamBo5.SCISSORS, vSCISSORS);
        row.put(RoShamBo5.ROCK, vROCK);
    }

    public Outcome compete(RoShamBo5 it) {
        return table.get(this).get(it); //获取当前枚举table.get(this)，再获取当前枚举与所比较的目标枚举的结果值table.get(this).get(it)
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo5.class, 20);
    }

}
