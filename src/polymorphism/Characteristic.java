package polymorphism;

public class Characteristic { //特征

    private String s;

    Characteristic(String s) {
        this.s = s;
        System.out.println("Creating Characteristic " + s);
    }
    protected void dispose() {
        System.out.println("disposing Characteristic " + s);
    }
}

/*Creating Characteristic is alive
  Creating Description Basic Living Creature
  LivingCreature()
  Creating Characteristic has heart
  Creating Description Animal not Vegetable
  Animal()
* */

