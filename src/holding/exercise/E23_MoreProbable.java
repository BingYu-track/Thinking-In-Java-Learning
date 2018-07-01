package holding.exercise;

import java.util.Map.Entry;
import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/1 17:33
 */
public class E23_MoreProbable {

    private static Random rand = new Random(47);
    public static void main(String[] args) {
        Map<Integer, Counter> m = new HashMap<Integer, Counter>();
        for(int i = 0; i < 10000000; i++) {
            // Produce a number between 0 and 100:
            int r = rand.nextInt(100);
            if(m.containsKey(r)){
                m.get(r).i++;
            }else{
                m.put(r, new Counter());
            }
        }
        // Make a histogram:
        List<HistoUnit> lst = new ArrayList<HistoUnit>();
        Iterator<Entry<Integer, Counter>> it =  m.entrySet().iterator();
        while(it.hasNext()) {
            Entry<Integer, Counter> entry = it.next();
            lst.add(new HistoUnit(entry.getValue(), entry.getKey())  //初始化HistoUnit
                    );
        }
        Collections.sort(lst); //sort方法要求List中的元素必须实现Comparable接口
        System.out.println("lst = " + lst);
    }
}
