package innerclasses;

public interface ClassInInterface {

    void howdy();

    class Test implements ClassInInterface {  //嵌套类实现了它的外围接口(接口中的内部类默认就是静态内部类)
        public void howdy() {
            System.out.println("Howdy!");
        }
        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
