package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/3 23:30
 */
public class CovariantArrays {

    public static void main(String[] args){
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple(); // OK
        fruit[1] = new Jonathan(); // OK
        // Runtime type is Apple[], not Fruit[] or Orange[]:
        try {
        // 编译器允许你加入Fruit对象，但fruit数组实际是个Apple数组，因此运行时报错
            fruit[0] = new Fruit(); // ArrayStoreException
        } catch(Exception e) {
            System.out.println(e);
        }
        try {
        // Compiler allows you to add Oranges: 同上
            fruit[0] = new Orange(); // ArrayStoreException
        } catch(Exception e) { System.out.println(e); }
    }
}
