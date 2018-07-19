package exceptions;

/**
 * @version 1.0
 * @Description: 异常的限制
 * @author: hxw
 * @date: 2018/7/17 23:34
 */
public class StormyInning extends Inning implements Storm {

    //在构造函数中，异常限制不存在---"可以抛出比父类构造器宽泛的异常"。但是由于在调用构造器之前会调用父类的构造器，因此子类构造器必须包含父类构造器声明的异常，否则编译器报错
    public StormyInning() throws RainedOut, BaseballException {

    }

    //  public StormyInning() throws RainedOut{} //Compile error

    public StormyInning(String s) throws Foul, BaseballException {

    }

    // 当重写父类方法时必须要保证抛出的异常是不能比父类方法更宽泛，只能是小，等于或不抛异常；否则编译器报错
    // 在这里由于父类方法没有抛异常，因此这个方法也不能抛异常(Java编程的思想：如果这里允许能抛出异常，那么当使用父类对象Inning调用walk方法时就不用做异常处理,
    // 而当使用子类对象StormyInning调用walk方法时又可能会抛出异常，这样Inning i = new StormyInning(); i.walk() 这种程序就可能抛出异常，但你可以又不用处理异常，明显程序不合理)。
    //---  public void walk() throws PopFoul {} //Compile error


    //当子类继承了一个父类，还实现了一个接口。且该接口与继承的父类拥有同名的方法，那么父类的方法会来实现接口的方法，因此这里是Inning类中的event方法来实现
    //Storm接口中的event方法，但是很明显，在Inning类要实现Storm接口时抛出的异常必须等于，小于或不抛RainedOut异常，然而Inning类中的event方法已经规定抛出的是
    //BaseballException，因此这样明显不行，这里就需要我们重写的event方法使抛出的异常均小于父类Inning和接口Storm中event方法抛出的异常，很明显，只有不抛异常才满足
    //这个条件。
    //---  public void event() throws RainedOut {} //Compile error 如果编译器允许这样，那么Inning i = new StormyInning(); i.event() 这种程序捕获的异常是BaseballException，而实际上
    //可能抛出的异常是RainedOut，这样最终捕获的异常不一致，明显错误。


    // 您可以选择不抛出任何异常(这样我们重写的event方法就能使抛出的异常均小于父类Inning和接口Storm中event方法抛出的异常)
    public void event() {}

     // If the method doesn’t already exist in the
     // base class, the exception is OK:
     public void rainHard() throws RainedOut {

     }

    // 实现了继承自Inning抽象类的方法，用于PopFoul异常继承父类方法atBat抛出的异常Foul，因此Inning i = new StormyInning(); i.atBat()可以捕获PopFoul异常
    public void atBat() throws PopFoul {

    }

    public static void main(String[] args) {
        //StormyInning si = new StormyInning(); //error你会发现这样写直接报错，由于构造器声明将抛出异常，在创建对象时需要我们强制对其捕获
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch(PopFoul e) {
            System.out.println("Pop foul");
        } catch(RainedOut e) {
            System.out.println("Rained out");
        } catch(BaseballException e) {
            System.out.println("Generic baseball exception");
        }
        // Strike not thrown in derived version.
        try {
        // 向上进行了转型
            Inning i = new StormyInning();
            i.atBat();
        // 这时捕获的异常就是父类方法里声明的异常了
        } catch(Strike e) {
            System.out.println("Strike");
        } catch(Foul e) {
            System.out.println("Foul");
        } catch(RainedOut e) {
            System.out.println("Rained out");
        } catch(BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }


}
