package innerclasses;

public class Parcel6 {

    private void internalTracking(boolean b) {
        if(b) {

            class TrackingSlip {
                private String id;
                TrackingSlip(String s) {
                    id = s;
                }
                String getSlip() { return id; }
            }

            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();

        }
        //在作用域外是无法访问TrackingSlip这个局部内部类 Can’t use it here! Out of scope:
        //! TrackingSlip ts = new TrackingSlip("x");
    }
    public void track() { internalTracking(true); }
    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }
}
