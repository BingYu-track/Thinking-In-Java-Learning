package interfaces.interfaceprocessor;

import java.util.Arrays;

public class Splitter extends StringProcessor {

    public String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}
