package innerclasses.override;

public class BigEgg extends Egg {

    public class Yolk {
        public Yolk() { System.out.println("BigEgg.Yolk()"); }
    }
    public static void main(String[] args) {
        new BigEgg();
        /*BigEgg bigEgg = new BigEgg();
        BigEgg.Yolk y1 = bigEgg.new Yolk();
        Egg egg = new BigEgg();
        Egg.Yolk y2 = egg.new Yolk();*/
    }
}
