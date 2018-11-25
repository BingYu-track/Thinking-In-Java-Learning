package generics;

import java.lang.reflect.Constructor;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/25 17:12
 */
 class ClassAsFactory2<T> {
    private Class<T> kind;

    public ClassAsFactory2(Class<T> kind){
        this.kind = kind;
    }

    /**
     * 该方法时指定一个int数值来创建泛型对象,没有对应的构造函数返回null
     * @param arg
     * @return
     */
    public T create(int arg){
        try {
            // 方法 1 (冗长的)
            for(Constructor<?> ctor : kind.getConstructors()) {
            // 查找具有单个参数的构造函数：
                Class<?>[] params = ctor.getParameterTypes();
                if(params.length == 1)
                    if(params[0] == int.class)
                        return kind.cast(ctor.newInstance(arg));
            }
            // 方法 2 (直接的)
            // Constructor<T> ct = kind.getConstructor(int.class);
            // return ct.newInstance(arg);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
