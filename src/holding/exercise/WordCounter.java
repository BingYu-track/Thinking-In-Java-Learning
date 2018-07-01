package holding.exercise;

import java.util.Comparator;

/**
 * @version 1.0
 * @Description: 单词包装类
 * @author: hxw
 * @date: 2018/6/26 7:49
 */
class WordCounter {

    public static final Comparator<WordCounter> CASE_INSENSITIVE_ORDER = new Comparator<WordCounter>() {
                public int compare(WordCounter o1, WordCounter o2) {
                    return o1.word.compareToIgnoreCase(o2.word); //按字典顺序比较两个字符串，不考虑大小写 根据指定 String 大于、等于还是小于此 String（不考虑大小写），分别返回一个负整数、0 或一个正整数
                }
            };
    private final String word; //保存的单词
    private int frequency; //单词出现的频率(计数)
    WordCounter(String word) {
        this.word = word;
        frequency = 1;
    }
    void incFrequency() {
        ++frequency;
    }
    String getWord() {
        return word;
    }
    int getFrequency() {
        return frequency;
    }
    public boolean equals(Object o) { //重写equals方法(只要对象是WordCounter并且其保存的单词的字符串是一样的即可)
        return o instanceof WordCounter && word.equals(((WordCounter)o).word);
    }
    public int hashCode() { //重写hashCode方法
        return word.hashCode();
    }
}
