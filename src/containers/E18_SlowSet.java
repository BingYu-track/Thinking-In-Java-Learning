package containers;

import net.mindview.util.Countries;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/6 21:15
 */
public class E18_SlowSet {

    public static void main(String[] args) {
        SlowSet<String> slowSet = new SlowSet<String>();
        slowSet.addAll(Countries.names(10));
        slowSet.addAll(Countries.names(10));
        slowSet.addAll(Countries.names(10));
        System.out.println(slowSet);
    }
}
