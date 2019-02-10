package containers;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/10 16:31
 */
public class Element {

    private String ident;
    public Element(String id) {
        ident = id;
    }
    public String toString() {
        return ident;
    }
    public int hashCode() {
        return ident.hashCode();
    }
    public boolean equals(Object r) {
        return r instanceof Element && ident.equals(((Element)r).ident);
    }
    protected void finalize() {
        System.out.println("Finalizing " + getClass().getSimpleName() + " " + ident);
    }
}
