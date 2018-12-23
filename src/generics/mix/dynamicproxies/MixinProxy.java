package generics.mix.dynamicproxies;

import exceptions.ExceptionMethods;
import generics.exception.E36_GenericExceptions;
import generics.mix.Basic;
import net.mindview.util.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Description: 动态代理实现混型
 * @author: hxw
 * @date: 2018/12/18 23:05
 */
class MixinProxy implements InvocationHandler {

    Map<String,Object> delegatesByMethod;

    public MixinProxy(TwoTuple<Object,Class<?>>... pairs) { //构造器传入多个二维元祖，二维元祖存放的是Object对象和Class对象
        delegatesByMethod = new HashMap<String,Object>();

        for(TwoTuple<Object,Class<?>> pair : pairs) { //遍历所有二维元祖内接口的Class对象里的每一个方法
            for(Method method : pair.second.getMethods()) {
                String methodName = method.getName();
                // The first interface in the map implements the method.
                if (!delegatesByMethod.containsKey(methodName)){ //map如果不包含方法，就把对象存进去
                    delegatesByMethod.put(methodName, pair.first);
                }
            }
        }

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String methodName = method.getName();
            Object delegate = delegatesByMethod.get(methodName);
            return method.invoke(delegate, args);
    }

    public static Object newInstance(TwoTuple... pairs) {
        //获取传入的二维元祖的数量作为Class数组长度，并将所有二维元祖里的接口Class对象封装进该数组
        Class[] interfaces = new Class[pairs.length];
        for(int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class)pairs[i].second;
        }
        //获取第一个二维元祖内对象的类加载器
        ClassLoader cl = pairs[1].first.getClass().getClassLoader();
        Object o = new Object();
        //return Proxy.newProxyInstance(o.getClass().getClassLoader(), interfaces, new MixinProxy(pairs)); 报错error: interface generics.mix.Basic is not visible from class loader
        return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs)); //
        //参数1: 类加载器，这里的类加载器可以使用任何自己创建的类来获取
        //参数2：代理类需要实现的接口(多个接口)
        //参数3：handler
    }

    public static void main(String[] args){
        ClassLoader classLoader = Object.class.getClassLoader();
        System.out.println(classLoader);
    }
}
