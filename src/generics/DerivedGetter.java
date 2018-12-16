package generics;

interface DerivedGetter extends OrdinaryGetter{

    // 重写接口 Base get() 方法，允许返回Base的子类
    Derived get();
}
