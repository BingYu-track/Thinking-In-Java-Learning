package containers;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/3/7 12:33
 */
public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) { //比较x,y的值
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "x:" + x + ",y:" + y;
    }
}
