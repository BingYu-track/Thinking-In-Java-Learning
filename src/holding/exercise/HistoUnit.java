package holding.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/1 17:32
 */
class HistoUnit implements Comparable<HistoUnit>{
    Counter counter;  //存放随机数出现的次数
    Integer val; //存放随机数字
    public HistoUnit(Counter counter, Integer val) {
        this.counter = counter;
        this.val = val;
    }
    public int compareTo(HistoUnit o) {
        int lv = o.counter.i; //要对比的次数
        int rv = counter.i; //当前的出现次数
        return (lv < rv ? -1 : (lv == rv ? 0 : 1));
    }
    public String toString() {
        return "Value = " + val + ", Occurrences = " + counter.i + "\n";
    }
}
