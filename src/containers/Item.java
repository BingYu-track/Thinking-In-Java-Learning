package containers;

import java.util.Random;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/5 19:07
 */
class Item implements Comparable<Item>{


    private static final Random rnd = new Random(47);
    private Integer priority = rnd.nextInt(101);
    public int compareTo(Item arg) {
        return priority < arg.priority ? -1 : priority == arg.priority ? 0 : 1;
    }
    public String toString() {
        return Integer.toString(priority);
    }
}
