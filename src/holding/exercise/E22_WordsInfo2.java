package holding.exercise;

import net.mindview.util.TextFile;

import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/6/26 7:51
 */
public class E22_WordsInfo2 {

    //默认访问权限
    //更新单词的出现次数
    static void updateStat(Iterator<WordCounter> it, WordCounter wc) {
        while(it.hasNext()) {
            WordCounter currentWC = it.next();
            if(currentWC.equals(wc)){
                currentWC.incFrequency();
            }
        }
    }

    public static void main(String[] args){
        Set<WordCounter> stat = new HashSet<WordCounter>();
        for(String word : new TextFile("D:\\Eclipse_Code\\ThinkInJava\\src\\holding\\exercise\\E22_WordsInfo2.java", "\\W+")) {
            WordCounter wc = new WordCounter(word); //单词包装类
            if(stat.contains(wc)){ //set.contains(o) 包含满足 (o==null ? e==null : o.equals(e)) 的元素 e 时返回 true。
                updateStat(stat.iterator(), wc);
            }else{
                stat.add(wc);
            }
        }
        List<WordCounter> l = new ArrayList<WordCounter>(stat);  //将Set转化为List(下面sort方法只能对List中的元素进行排序，因此需要将Set转为List)
        Collections.sort(l, WordCounter.CASE_INSENSITIVE_ORDER); //根据指定比较器产生的顺序对指定列表进行排序
        for(WordCounter wc : l){
            System.out.println(wc.getWord() + " => " + wc.getFrequency());
        }
    }


}
