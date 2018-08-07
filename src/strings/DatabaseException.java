package strings;

/**
 * @version 1.0
 * @Description: String.format(String format, Object... args),其内部就是创建的Formatter对象
 * @author: hxw
 * @date: 2018/8/7 21:42
 */
public class DatabaseException extends Exception{
    public DatabaseException(int transactionID, int queryID, String message) {
        /*String str = String.format("(t%d, q%d) %s", transactionID, queryID, message);
        super(str);
        注意不能这样写，因为super必须位于第一行
         */
        super(String.format("(t%d, q%d) %s", transactionID,queryID, message));
    }
    public static void main(String[] args) {
        try {
            throw new DatabaseException(3, 7, "Write failed");
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
