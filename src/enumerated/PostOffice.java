package enumerated;
import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

class Mail {

    // The NO’s lower the probability of random selection:
    enum GeneralDelivery {YES,NO1,NO2,NO3,NO4,NO5}
    enum Scannability {UNSCANNABLE,YES1,YES2,YES3,YES4}
    enum Readability {ILLEGIBLE,YES1,YES2,YES3,YES4}
    enum Address {INCORRECT,OK1,OK2,OK3,OK4,OK5,OK6}
    enum ReturnAddress {MISSING,OK1,OK2,OK3,OK4,OK5}
    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    static long counter = 0;
    long id = counter++;
    public String toString() {
        return "Mail " + id;
    }
    public String details() {
        return toString() +
                ", General Delivery: " + generalDelivery +
                ", Address Scanability: " + scannability +
                ", Address Readability: " + readability +
                ", Address Address: " + address +
                ", Return address: " + returnAddress;
    }
    // Generate test Mail: 生成邮件对象
    public static Mail randomMail() {
        Mail m = new Mail();
        m.generalDelivery= Enums.random(GeneralDelivery.class); //从每个枚举类中随机选取一个枚举实例赋给成员变量
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;
    }

    public static Iterable<Mail> generator(final int count) {
        return new Iterable<Mail>() {
            int n = count;
            public Iterator<Mail> iterator() { //注意: 任何实现了Iterable接口的类，都可以将其用于foreach语句中
                return new Iterator<Mail>() {
                    public boolean hasNext() { return n-- > 0; } //不断递减
                    public Mail next() { return randomMail(); } //生成邮件
                    public void remove() { // Not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

}
/**
 * @version 1.0
 * @Description: 责任链模式
 * @author: bingyu
 * @date: 2021/6/24
 */
public class PostOffice {

    enum MailHandler {

        GENERAL_DELIVERY {
            boolean handle(Mail m) {
                switch(m.generalDelivery) {
                    case YES:
                        print("Using general delivery for " + m);
                        return true;
                    default: return false;
                }
            }
        },
        MACHINE_SCAN {
            boolean handle(Mail m) {
                switch(m.scannability) {
                    case UNSCANNABLE: return false;
                    default:
                        switch(m.address) {
                            case INCORRECT: return false;
                            default:
                                print("Delivering "+ m + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            boolean handle(Mail m) {
                switch(m.readability) {
                    case ILLEGIBLE: return false;
                    default:
                        switch(m.address) {
                            case INCORRECT: return false;
                            default:
                                print("Delivering " + m + " normally");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER {
            boolean handle(Mail m) {
                switch(m.returnAddress) {
                    case MISSING: return false;
                    default:
                        print("Returning " + m + " to sender");
                        return true;
                }
            }
        };
        abstract boolean handle(Mail m);
    }

    static void handle(Mail m) {
        for(MailHandler handler : MailHandler.values()) {
            if(handler.handle(m)) {
                return;
            }
        }
        print(m + " is a dead letter");
    }
    public static void main(String[] args) {
        Iterable<Mail> generator = Mail.generator(10); //迭代器 任何实现了Iterable接口的类，都可以将其用于foreach语句中
        for (Mail mail : generator) {
            print(mail.details()); //打印邮件
            handle(mail);
            print("*****");
        }
    }


}
