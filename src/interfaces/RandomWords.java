package interfaces;

import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class RandomWords implements Readable {

    private static Random rand = new Random(47); //创建随机数生成器
    private static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] vowels = "aeiou".toCharArray();
    private int count;  //表示能添加到字符缓冲区的字符数
    public RandomWords(int count) {
        this.count = count;
    }
    public int read(CharBuffer cb) { //cb ---将要读入字符的缓冲区 该方法是在Scanner对象中调用readInput方法调用的
        if(count-- == 0)
            return -1; // 返回-1时表示已经位于缓冲区末尾，停止输入
        cb.append(capitals[rand.nextInt(capitals.length)]); //返回一个伪随机数[0,26)区间的int值,并将该int值对应的capitals数组位置的值，并将该值放入字符缓冲区
        for(int i = 0; i < 4; i++) {
            cb.append(vowels[rand.nextInt(vowels.length)]);
            cb.append(lowers[rand.nextInt(lowers.length)]);
        }
        cb.append(" ");
        return 10; // Number of characters appended
    } //返回值含义：添加到缓冲区的 char 值的数量，如果此字符源位于缓冲区末端，则返回 -1
    public static void main(String[] args) {
        //构造一个新的 Scanner，它生成的值是从指定源扫描的
        Scanner s = new Scanner(new RandomWords(10)); //Scanner扫描器可以从实现 Readable 接口的任何对象读取文本
        while(s.hasNext()){
            System.out.println(s.next()); //输出了10次
        }
    }
}
