package polymorphism;

/**
* @Description:初始化顺序与销毁顺序 (多个对象不共用一个成员)
* @Author:hxw
* @Date:2018/4/6 19:52
*/
public class Frog extends Amphibian { //青蛙

    private Characteristic p = new Characteristic("Croaks");
    private Description t = new Description("Eats Bugs");
    public Frog() { System.out.println("Frog()"); }
    protected void dispose() {
        System.out.println("Frog dispose");
        t.dispose(); //注意，这里清理成员时的顺序与声明时的顺序要相反
        p.dispose();
        super.dispose(); //这里调用了父类的dispose方法
    }
    public static void main(String[] args) {
        Frog frog = new Frog();
        System.out.println("Bye!");
        frog.dispose();
    }

    /*Creating Characteristic is alive
    Creating Description Basic Living Creature
    LivingCreature()
    Creating Characteristic has heart
    Creating Description Animal not Vegetable
    Animal()
    Creating Characteristic can live in water
    Creating Description Both water and land
    Amphibian()
    Creating Characteristic Croaks
    Creating Description Eats Bugs
    Frog()
    Bye!
    Frog dispose
    disposing Description Eats Bugs
    disposing Characteristic Croaks
    Amphibian dispose
    disposing Description Both water and land
    disposing Characteristic can live in water
    Animal dispose
    disposing Description Animal not Vegetable
    disposing Characteristic has heart
    LivingCreature dispose
    disposing Description Basic Living Creature
    disposing Characteristic is alive*/

}
