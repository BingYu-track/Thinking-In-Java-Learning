package typeinfo;

import java.lang.reflect.*;
import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/10 23:18
 */
class NullRobotProxyHandler implements InvocationHandler {

    private String nullName;
    private Robot proxied = new NRobot();
    NullRobotProxyHandler(Class<? extends Robot> type) {
        nullName = type.getSimpleName() + " NullRobot";
    }

    /**
     * 机器人空对象定义类
     */
    private class NRobot implements Null, Robot {
        public String name() {
            return nullName;
        }
        public String model() {
            return nullName;
        }
        public List<Operation> operations() {
            return Collections.emptyList(); //返回一个空的且不可变的列表。
        }
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied, args);
    }
}
