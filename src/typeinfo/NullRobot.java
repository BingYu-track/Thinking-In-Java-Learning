package typeinfo;

import java.lang.reflect.Proxy;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/10 23:21
 */
public class NullRobot {

    public static Robot newNullRobot(Class<? extends Robot> type) {
        return (Robot)Proxy.newProxyInstance(
                NullRobot.class.getClassLoader(),
                new Class[]{ Null.class, Robot.class },
                new NullRobotProxyHandler(type)
        );
    }

    public static void main(String[] args) {
        Robot[] bots = {
                new SnowRemovalRobot("SnowBee"),
                newNullRobot(SnowRemovalRobot.class)
        };
        for(Robot bot : bots){
            Robot.Test.test(bot);
        }
    }


}
