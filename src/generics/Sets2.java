package generics;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/10/6 18:11
 */
class Sets2 {

    @SuppressWarnings("unchecked")
    protected static <T> Set<T> copy(Set<T> s) {
        if(s instanceof EnumSet)
            return ((EnumSet)s).clone();
        return new HashSet<T>(s);
    }

    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = copy(a);
        result.addAll(b);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = copy(a);
        result.retainAll(b);
        return result;
    }

    public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        Set<T> result = copy(superset);
        result.removeAll(subset);
        return result;
    }

    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }

}
