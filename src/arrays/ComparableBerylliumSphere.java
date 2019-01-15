package arrays;

import java.lang.reflect.Field;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/15 8:49
 */
public class ComparableBerylliumSphere extends BerylliumSphere implements Comparable<BerylliumSphere>{

    // BerylliumSphere.id is private, so we need to use reflection to get its value.
    static long getID(BerylliumSphere bs) {
        try {
            Field fid = BerylliumSphere.class.getDeclaredField("id");
            fid.setAccessible(true);
            return fid.getLong(bs);
        } catch(Exception e) {
            e.printStackTrace();
            return 0L; // Bogus value
        }
    }

    public int compareTo(BerylliumSphere rv) {
        long id = getID(this);
        long rvid = getID(rv);
        return (id < rvid ? -1 : (id == rvid ? 0 : 1));
    }
}
