package typeinfo.pets2;

import typeinfo.pets.Manx;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/5 12:47
 */
public class Cymric extends Manx {
    public static class Factory implements typeinfo.factory.Factory<Cymric> {
        public Cymric create() { return new Cymric(); }
    }
}