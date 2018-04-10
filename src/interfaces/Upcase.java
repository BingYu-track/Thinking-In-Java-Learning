package interfaces;

public class Upcase extends Processor {

    String process(Object input) { // 协变类型返回(重写了父类的方法，返回类型是父类方法的子类)
        return ((String)input).toUpperCase();
    }
}
