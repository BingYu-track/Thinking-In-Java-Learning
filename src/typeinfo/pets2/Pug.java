package typeinfo.pets2;

import typeinfo.pets.Dog;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/5 12:50
 */
public class Pug extends Dog {
    public static class Factory implements typeinfo.factory.Factory<Pug> {
        public Pug create() { return new Pug(); }
    }
}