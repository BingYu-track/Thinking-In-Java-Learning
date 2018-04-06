package polymorphism;

public class Sub extends Super {

    public int field = 1;

    public int getField(){
        return field;
    }

    public int getSuperField(){
        return super.field;
    }

    public static String staticGet(){
        return "Sub staticGet()";
    }
}
