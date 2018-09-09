package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/9 20:00
 */
class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if(args != null){
            for(Object arg : args){
                System.out.println(" " + arg);
            }
        }
        long start = System.nanoTime();
        Object ret = method.invoke(proxied, args);
        long duration = System.nanoTime() - start;
        System.out.println("METHOD-CALL TIME: " + duration);
        return ret;
    }
}
