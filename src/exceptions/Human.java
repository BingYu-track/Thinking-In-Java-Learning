package exceptions;

/**
 * @version 1.0
 * @Description: 子类的异常也可以被其父类异常处理程序捕获
 * @author: hxw
 * @date: 2018/8/2 8:28
 */
public class Human {
    public static void main(String[] args) {
        //这里如果类型完全匹配，就进入完全匹配的catch子句，父类的catch子句不执行
        try {
            throw new Sneeze();
        } catch(Sneeze s) {
            System.out.println("Caught Sneeze");
        } catch(Annoyance a) {
            //这里不会到达
            System.out.println("Caught Annoyance");
        }
        //这里没有完全匹配，但Annoyance是Sneeze的父类，因此也可以捕获其异常
        try {
            throw new Sneeze();
        } catch(Annoyance a) {
            System.out.println("Caught Annoyance");
        }
    }
}
