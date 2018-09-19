package typeinfo;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/19 21:29
 */
class Music5 {
    static void tune(Instrument i) {
        // ...
        i.play();
    }
    static void tuneAll(Instrument[] e) {
        for(Instrument instrument : e)
            tune(instrument);
    }
    static void prepareAll(Instrument[] e) {
        for(Instrument instrument : e)
            instrument.prepareInstrument();
    }
}
