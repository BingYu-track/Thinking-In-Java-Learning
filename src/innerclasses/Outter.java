package innerclasses;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/2 17:11
 */
public class Outter {

    private Inner in = new Inner();

    public Outter() {
        //Outter outter = new Outter();构造器中创建对象会导致程序无法停止，发生java.lang.StackOverflowError
    }

    class Inner{
         void p(){
             System.out.println("yes");
         }
    }

    public static void main(String[] args){
        Outter outter = new Outter();
        outter.in.p();
    }
}
