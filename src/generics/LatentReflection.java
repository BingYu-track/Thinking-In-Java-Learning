package generics;

/**
 * @version 1.0
 * @Description: 使用反射补偿潜在类型机制
 * @author: hxw
 * @date: 2018/12/23 20:20
 */
public class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Robot());
        CommunicateReflectively.perform(new Mime());
        /*
            SmartDog、Robot和Mime这些类都是批次分离的，没有任何公共的类和接口，通过反射，CommunicateReflectively.perform()能够动态
            的确定所需要的方法是否可用并调用它
        */
    }
}
