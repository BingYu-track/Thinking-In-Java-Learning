package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/12 0:31
 */
public class CRGWithBasicHolder {

    public static void main(String[] args) {
        Subtype st1 = new Subtype(), st2 = new Subtype();
        st1.set(st2);
        Subtype st3 = st1.get();
        st1.f();
    }
}
