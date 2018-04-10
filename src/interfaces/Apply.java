package interfaces;

public class Apply {

    public static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }

    public static String s = "Disagreement with beliefs is by definition incorrect";

    public static void main(String[] args) {
        process(new Upcase(), s); //转为大写
        /*Using Processor Upcase
          DISAGREEMENT WITH BELIEFS IS BY DEFINITION INCORRECT*/

        process(new Downcase(), s);
        /*Using Processor Downcase
          disagreement with beliefs is by definition incorrect  */

        process(new Splitter(), s);
        /*Using Processor Splitter
         [Disagreement, with, beliefs, is, by, definition, incorrect] */
    }
}
