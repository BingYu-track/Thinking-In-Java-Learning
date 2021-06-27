package annotations;
import net.mindview.atunit.*;
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/26
 */
public class Testable {

    public void execute() {
        System.out.println("Executing..");
    }
    @Test
    void testExecute() { execute(); }
}
