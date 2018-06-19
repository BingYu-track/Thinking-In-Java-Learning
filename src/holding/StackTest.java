package holding;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/6/19 18:14
 */
public class StackTest {

    public static void main(String[] args){
        Stack<String> stack = new Stack<String>();
        for(String s : "My dog has fleas".split(" ")){
            stack.push(s);
        }

        while(!stack.empty()){
            System.out.print(stack.pop() + " ");
        }

    }
}
