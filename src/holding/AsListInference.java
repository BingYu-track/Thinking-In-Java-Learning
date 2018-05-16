package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AsListInference {

    public static void main(String[] args){
        List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder());
        //注意，这里只有在java8之前编译器才会报错，因为Java8编译器在类型推断方面有很大的提升
        List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());
        // Compiler says:
        // found : java.util.List<Powder>
        // required: java.util.List<Snow>
        // Collections.addAll() doesn’t get confused:
        List<Snow> snow3 = new ArrayList<Snow>();
        Collections.addAll(snow3, new Light(), new Heavy());
        // Give a hint using an explicit type argument specification:
        List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());
    }
}
