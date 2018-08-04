package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/3 23:57
 */
public class TurnOffChecking {

    public static void main(String[] args){
        WrapCheckedException wce = new WrapCheckedException();
        // 您可以在不使用try块的情况下调用throwRuntimeException()，因为RuntimeException不强制要求捕获，即使发生了异常，控制台也会打出原始异常信息
        wce.throwRuntimeException(3);
        //或者你可以选择捕获特定异常:
        for(int i = 0; i < 4; i++){
            try {
                if(i < 3)
                    wce.throwRuntimeException(i);
                else
                    throw new SomeOtherException();
            } catch(SomeOtherException e) {
                System.out.println("SomeOtherException: " + e);
            } catch(RuntimeException re) {
                try {
                    throw re.getCause(); //把被包装的原始异常抛出(getCause方法属于Throwable)
                } catch(FileNotFoundException e) {
                    System.out.println("FileNotFoundException: " + e);
                } catch(IOException e) {
                    System.out.println("IOException: " + e);
                } catch(Throwable e) {
                    /*注意这里一定要catch Throwable,因为re.getCause()返回一个Throwable对象，因此在编译器看来throw re.getCause();
                      相当于throw Throwable异常，因此必须处理Throwable */
                    System.out.println("Throwable: " + e);
                }
            }
        }
    }
}
