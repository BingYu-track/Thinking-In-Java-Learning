package innerclasses;

public interface ClassInInterface {

    void howdy();

    class Test implements ClassInInterface {  //嵌套类
        public void howdy() {
            System.out.println("Howdy!");
        }
        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
