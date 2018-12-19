package generics.mix.dynamicproxies;

import generics.mix.*;
import net.mindview.util.*;
import static net.mindview.util.Tuple.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/18 23:08
 */
public class DynamicProxyMixin {

    public static void main(String[] args) {
        //获取所有接口混合的代理对象
        Object mixin = MixinProxy.newInstance(
                tuple(new BasicImp(), Basic.class),
                tuple(new TimeStampedImp(), TimeStamped.class),
                tuple(new SerialNumberedImp(),SerialNumbered.class));
        Basic b = (Basic)mixin;
        TimeStamped t = (TimeStamped)mixin;
        SerialNumbered s = (SerialNumbered)mixin;
        b.set("Hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());
    }
}
