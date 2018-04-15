package interfaces.interfaceprocessor;

public class Downcase extends StringProcessor {

    public String process(Object input) {
        return ((String)input).toLowerCase();
    }
}
