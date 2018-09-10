package typeinfo;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/9 21:44
 */
public class Person {
    public final String first;
    public final String last;
    public final String address;
    public static final Person NULL = new NullPerson();
    // etc.
    public Person(String first, String last, String address){
        this.first = first;
        this.last = last;
        this.address = address;
    }
    public String toString() {
        return "Person: " + first + " " + last + " " + address;
    }

    //静态内部类
    public static class NullPerson extends Person implements Null {
        private NullPerson() {
            super("None", "None", "None");
        }
        public String toString() { return "NullPerson"; }
    }

}
