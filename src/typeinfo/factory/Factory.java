package typeinfo.factory;

public interface Factory <T> {

    T create(); //这里泛型参数T使得create()方法可以在每种Factory实现中返回不同的类型
}
