package generics;

import java.util.EmptyStackException;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/11 23:01
 */
public class E33_GenericCast2 {

    public static final int SIZE = 10;

    public static void main(String[] args){
        FixedSizeStack2<String> strings = new FixedSizeStack2<String>(SIZE);
        for(String s : "A B C D E F G H I J".split(" ")){
            strings.push(s);
        }
        for(int i = 0; i < SIZE; i++) {
            String s = strings.pop();
            printnb(s + " ");
        }
        print();
        try {
            strings.pop();
        } catch(EmptyStackException e) {
            print("Stack is empty");
        }
        strings = new FixedSizeStack2<String>(1);
        strings.push("A");
        try {
            strings.push("B");
        } catch(FullStackException e) {
            print("Stack is full");
        }

    }
}
