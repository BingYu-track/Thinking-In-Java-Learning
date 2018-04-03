package reusing;

import net.mindview.util.Print;

public class Soap {

    private String s;
    Soap(){
        Print.print("Soap()");
        s = "Constructed";
    }
    public String toString() { return s; }
}
