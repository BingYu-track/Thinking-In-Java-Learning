package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/13 21:32
 */
class D {

    // Can’t do this:
// class E extends SelfBounded<D> {}
// Compile error: Type parameter D is not within its bound 因为D没有继承 SelfBounded<D>
    //class E extends SelfBounded<B> {} 编译错误，理由同上
}
