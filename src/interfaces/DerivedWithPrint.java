package interfaces;

public class DerivedWithPrint extends BaseWithPrint {

    int i = 47;
    public void print() {
        System.out.println("i = " + i);
    }
}
