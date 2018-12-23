package generics;

import java.lang.reflect.Method;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/23 20:38
 */
public class Apply {

    /**
     * 调用序列集合seq中所有对象的指定方法f
     * @param seq 序列集合
     * @param f 指定方法
     * @param args 方法参数
     * @param <T> 表示序列中包含的类型
     * @param <S> 表示一个继承了Iterable接口的序列集合
     */
    public static <T, S extends Iterable<? extends T>> void apply(S seq, Method f, Object... args) {
        try {
            for(T t: seq)
                f.invoke(t, args);
        } catch(Exception e) {
            // Failures are programmer errors
            throw new RuntimeException(e);
        }
    }
}
