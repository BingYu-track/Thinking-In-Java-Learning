package holding.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/1 22:16
 */
class Command { //命令

    private final String cmd;
    Command(String cmd) {
        this.cmd = cmd;
    }
    public void operation() {
        System.out.println(cmd);
    }
}
