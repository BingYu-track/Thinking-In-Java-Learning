package interfaces;

public class Processor {

    public String name() {
        return getClass().getSimpleName(); //返回源代码中给出的底层类的简称
    }
    Object process(Object input) { return input; }
}
