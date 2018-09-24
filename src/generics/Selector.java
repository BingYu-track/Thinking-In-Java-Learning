package generics;

interface Selector<T> {

    boolean end();
    T current();
    void next();
}
