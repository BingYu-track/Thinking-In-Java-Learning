package generics.mix.dynamicproxies;

import generics.mix.*;

import static net.mindview.util.Tuple.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/23 18:40
 */
public class DynamicProxyMixin2 {
    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(
                tuple(new BasicImp(), Basic.class),
                tuple(new TimeStampedImp(), TimeStamped.class),
                tuple(new SerialNumberedImp(),SerialNumbered.class),
                tuple(new ColoredImp(), Colored.class));
        Basic b = (Basic)mixin;
        TimeStamped t = (TimeStamped)mixin;
        SerialNumbered s = (SerialNumbered)mixin;
        Colored c = (Colored)mixin;
        b.set("Hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());
        System.out.println(c.getColor());
    }
}
