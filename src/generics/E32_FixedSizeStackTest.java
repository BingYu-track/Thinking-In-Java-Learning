package generics;

/**
 * @version 1.0
 * @Description: 超出边界
 * @author: hxw
 * @date: 2018/12/11 22:49
 */
public class E32_FixedSizeStackTest {
    public static void main(String[] args) {
        FixedSizeStack<Integer> stack = new FixedSizeStack<Integer>(1);
        stack.push(1);
        System.out.println(stack.pop());
        try {
            stack.pop();
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }
        stack = new FixedSizeStack<Integer>(1);
        stack.push(2);
        try {
            stack.push(2); //超过长度
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }
    }

}
