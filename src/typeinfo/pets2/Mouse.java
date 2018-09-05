package typeinfo.pets2;

import typeinfo.pets.Rodent;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/5 12:49
 */
public class Mouse extends Rodent {
    public static class Factory implements typeinfo.factory.Factory<Mouse> {
        public Mouse create() { return new Mouse(); }
    }
}
