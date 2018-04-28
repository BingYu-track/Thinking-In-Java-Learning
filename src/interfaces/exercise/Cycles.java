package interfaces.exercise;

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
