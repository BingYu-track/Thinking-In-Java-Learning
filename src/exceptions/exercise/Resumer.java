package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/8 20:46
 */
class Resumer {
    static int count = 3;
    static void f() throws ResumerException {
        if(--count > 0){
            System.out.println(count);
            throw new ResumerException();
        }
    }
}
