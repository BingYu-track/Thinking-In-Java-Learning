package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @version 1.0
 * @Description: 使用RuntimeException包装受查异常避免"异常吞食"
 * @author: hxw
 * @date: 2018/8/3 23:56
 */
class WrapCheckedException {

    void throwRuntimeException(int type) {
        try {//这里模拟受查异常声明，需要强制try-catch，如果catch子句里什么都不处理(因为程序员可能没有想好怎么处理)就会发生异常吞食，实际异常发生了，
            //但由于catch掉后，我们并不知道发生了异常，因此我们可以做如下处理将要处理的异常包装到RuntimeException,再在后面用getCause()捕获原始异常即可。
            switch(type) {
                case 0: throw new FileNotFoundException();
                case 1: throw new IOException();
                case 2: throw new RuntimeException("Where am I?");
                default: return;
            }
        } catch(Exception e) { //这里进行了封装，无论上面抛的是什么异常，这里最终都是抛的运行时异常，但实际根本的来源是上面的异常，这样就能保证异常不会吞食
            throw new RuntimeException(e); //
        }
    }
}
