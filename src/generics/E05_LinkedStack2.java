package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/24 22:09
 */
public class E05_LinkedStack2 {

    public static void main(String[] args) {
        LinkedStack2<String> lss = new LinkedStack2<String>();
        for(String s : "Phasers on stun!".split(" ")){
            lss.push(s);
        }
        String s;
        while((s = lss.pop()) != null){
            System.out.println(s);
        }
    }
}
