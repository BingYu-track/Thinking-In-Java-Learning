package typeinfo.pets2;

import typeinfo.pets.Cat;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/5 12:48
 */
public class EgyptianMau extends Cat {
    public static class Factory implements typeinfo.factory.Factory<EgyptianMau> {
        public EgyptianMau create() {
            return new EgyptianMau();
        }
    }
}
