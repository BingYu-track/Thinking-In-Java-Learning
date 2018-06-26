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
            WordCounter wc = new WordCounter(word);
            if(stat.contains(wc)){
                updateStat(stat.iterator(), wc);
            }else{
                stat.add(wc);
            }
        }
        List<WordCounter> l = new ArrayList<WordCounter>(stat);
        Collections.sort(l, WordCounter.CASE_INSENSITIVE_ORDER);
        for(WordCounter wc : l){
            System.out.println(wc.getWord() + " => " + wc.getFrequency());
        }
    }


}
