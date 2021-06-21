package enumerated;

/**
 * @version 1.0
 * @Description: 覆盖枚举的toString方法
 * @author: bingyu
 * @date: 2021/6/21
 */
public enum SpaceShip {
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;
    public String toString() { //这个方法是将首字母进行了大写
        String id = name();  //直接调用的父类Enum.java类的方法
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }
    public static void main(String[] args) {
        for(SpaceShip s : values()) {
            System.out.println(s);
        }
    }
}
