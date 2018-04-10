package interfaces;

import java.util.Arrays;

public class Splitter extends Processor{
    String process(Object input) {
        // The split() argument divides a String into pieces:
        return Arrays.toString(((String)input).split(" "));
    }
}
