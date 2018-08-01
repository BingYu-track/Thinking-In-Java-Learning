package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/1 23:29
 */
class FailingConstructor {
    FailingConstructor(boolean fail) throws ConstructionException {
        if(fail) throw new ConstructionException();
    }
}
