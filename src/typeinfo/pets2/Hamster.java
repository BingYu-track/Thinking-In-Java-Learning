package typeinfo.pets2;

import typeinfo.pets.Rodent;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/5 12:48
 */
public class Hamster extends Rodent {
    public static class Factory implements typeinfo.factory.Factory<Hamster> {
        public Hamster create() { return new Hamster(); }
    }
}
