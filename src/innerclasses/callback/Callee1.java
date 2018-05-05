package innerclasses.callback;

class Callee1 implements Incrementable {

    private int i = 0;
    public void increment() {
        i++;
        System.out.println(i);
    }
}
