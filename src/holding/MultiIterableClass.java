package holding;

import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/5 12:39
 */
public class MultiIterableClass extends IterableClass{

    public Iterable<String> reversed() {
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    int current = words.length - 1;
                    public boolean hasNext() { return current > -1; }
                    public String next() { return words[current--]; }
                    public void remove() { // Not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<String> randomized() {
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                List<String> shuffled = new ArrayList<String>(Arrays.asList(words)); //将Arrays.asList(words)生成的List创建了一个副本为了保持words数组不会被修改
                Collections.shuffle(shuffled, new Random(47)); //打乱顺序
                return shuffled.iterator(); //返回打乱顺序的List的iterator
            }
        };
    }

    public static void main(String[] args) {
        MultiIterableClass mic = new MultiIterableClass();
        System.out.println("反转遍历前："+mic.words);
        for(String s : mic.reversed()){ //反转遍历
            System.out.print(s + " ");
        }
        System.out.println("反转遍历后："+mic.words);
        for(String s : mic.randomized()){ //打乱顺序遍历
            System.out.print(s + " ");
        }
        System.out.println("打乱顺序遍历后:"+mic.words); //发现words数组顺序没有改变
        System.out.println();
        for(String s : mic){ //正常遍历
            System.out.print(s + " ");
        }
        System.out.println("正常遍历后:"+mic.words);
    }
}
