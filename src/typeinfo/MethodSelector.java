package typeinfo;

import java.lang.reflect.*;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/9 20:27
 */
class MethodSelector implements InvocationHandler {
    private Object proxied;
    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("interesting"))
            print("Proxy detected the interesting method"); //代理检测到interesting方法
        return method.invoke(proxied, args);
    }
}
