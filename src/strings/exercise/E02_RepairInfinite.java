package strings.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/6 20:28
 */
public class E02_RepairInfinite {
    public String toString() {
        return " E02_RepairInfinite address: " + super.toString() + "\n";
    }
    public static void main(String[] args) {
        List<E02_RepairInfinite> v = new ArrayList<E02_RepairInfinite>();
        for(int i = 0; i < 10; i++){
            v.add(new E02_RepairInfinite());
        }
        System.out.println(v);
    }
}
