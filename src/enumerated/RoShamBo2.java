package enumerated;
import static enumerated.Outcome.*;
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/26
 */
public enum RoShamBo2 implements Competitor<RoShamBo2>{
    PAPER(DRAW, LOSE, WIN),
    SCISSORS(WIN, DRAW, LOSE),
    ROCK(LOSE, WIN, DRAW); //所有枚举实例，在定义时就已经把各种比较结果保存好了
    private Outcome vPAPER, vSCISSORS, vROCK;
    RoShamBo2(Outcome paper,Outcome scissors,Outcome rock) {
        this.vPAPER = paper; //各个实例比较paper时保存的结果值
        this.vSCISSORS = scissors; //各个实例比较scissors时保存的结果值
        this.vROCK = rock; //各个实例比较rock时保存的结果值
    }
    public Outcome compete(RoShamBo2 it) { //这个方法，只要按部就班的把比较对象安照结果值匹配就行了
        switch(it) {
            default:
            case PAPER: return vPAPER;
            case SCISSORS: return vSCISSORS;
            case ROCK: return vROCK;
        }
    }
    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class, 20);
    }
}
