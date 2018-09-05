package typeinfo.pets2;

import typeinfo.pets.Cat;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/5 12:49
 */
public class Manx extends Cat {
    public static class Factory implements typeinfo.factory.Factory<Manx> {
        public Manx create() { return new Manx(); }
    }
}
