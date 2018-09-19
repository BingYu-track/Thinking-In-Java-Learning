package typeinfo;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/19 21:30
 */
public class E26_ClearSpitValve {

    public static void main(String[] args) {
        Instrument[] orchestra = {
                new Wind(), new Percussion(),
                new Stringed(), new Brass(),
                new Woodwind(),
        };
        Music5.prepareAll(orchestra);
        Music5.tuneAll(orchestra);
    }
}
