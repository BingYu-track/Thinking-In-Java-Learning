package typeinfo.toys;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/9 16:23
 */
class SuperToy extends FancierToy{
    int IQ;
    public SuperToy(int intelligence) { IQ = intelligence; }
    public String toString() {
        return "I'm a SuperToy. I'm smarter than you.";
    }
}
