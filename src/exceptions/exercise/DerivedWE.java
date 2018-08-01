package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/1 23:11
 */
class DerivedWE extends BaseWithException{

    // 产生编译错误: 未处理异常Except1
    // ! public DerivedWE() {}

    // 编译报错: super()必须是构造函数中的第一个语句(这说明了子类无法捕获父类构造器抛出的异常 ):
    /*public DerivedWE() {
        try {
            super();
        } catch(Except1 ex1) {

        }
    }*/
    public DerivedWE() throws Except1 {}
}
