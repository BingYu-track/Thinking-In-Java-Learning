package typeinfo.pets2;

import typeinfo.pets.Rodent;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/5 12:50
 */
public class Rat extends Rodent {
    public static class Factory implements typeinfo.factory.Factory<Rat> {
        public Rat create() { return new Rat(); }
    }
}
