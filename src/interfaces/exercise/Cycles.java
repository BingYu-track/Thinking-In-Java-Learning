package interfaces.exercise;

/**
* @Description:适配器模式
* @Author:hxw
* @Date:2018/4/28 11:32
*/
public class Cycles {

    public static void getCycleWheelNum(CycleFactory factory){
        Cycle cycle = factory.getCycle();
        int wheelNum = cycle.getWheel();
        System.out.println(cycle.getClass().getSimpleName()+":"+wheelNum);
    }

    public static void main(String[] args){
        getCycleWheelNum(new UnicycleFactory());
        getCycleWheelNum(new BicycleFactory());
        getCycleWheelNum(new TricycleFactory());
    }
}
