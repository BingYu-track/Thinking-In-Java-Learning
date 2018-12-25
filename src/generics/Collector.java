package generics;

interface Collector<T> extends UnaryFunction<T,T> { //收集器
    T result(); // 传入参数并得到结果
}
