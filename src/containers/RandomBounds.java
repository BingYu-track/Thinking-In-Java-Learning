package containers;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/8 21:45
 */
public class RandomBounds {

    static void usage() {
        print("Usage:");
        print("\tRandomBounds lower");
        print("\tRandomBounds upper");
        System.exit(1);
    }
    public static void main(String[] args) {
        args = new String[]{"java RandomBounds lower"};
        if(args.length != 1)
            usage();
        if(args[0].equals("lower")) {
            while(Math.random() != 0.0)
                ; // Keep trying
            print("Produced 0.0!");
        } else if(args[0].equals("upper")) {
            while(Math.random() != 1.0)
                ; // Keep trying
            print("Produced 1.0!");
        }
        else
            usage();
    }
}
