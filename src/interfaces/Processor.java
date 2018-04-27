package interfaces;

public class Processor {

    public String name() {
        return getClass().getSimpleName(); //返回源代码中当前类的简称
    }
    Object process(Object input) { return input; }
}
