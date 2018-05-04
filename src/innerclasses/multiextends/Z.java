package innerclasses.multiextends;


public class Z extends D{

    E makeE(){
        return new E() {  //这里匿名内部类继承了E类，由于java中类只能实现单继承，而加上匿名内部类从而实现了多继承
        };
    }

}
