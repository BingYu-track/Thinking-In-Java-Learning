package enumerated;
import java.util.*;
import net.mindview.util.*;
import static enumerated.Input.*;
import static net.mindview.util.Print.*;

enum Category { //使用Category枚举对贩卖机的状态进行了分类
    MONEY(NICKEL/*5美分*/, DIME/*10美分*/, QUARTER/*25美分*/, DOLLAR/*100美分，即1美元*/){}, //金额
    ITEM_SELECTION(TOOTHPASTE/*牙膏*/, CHIPS/*薯片*/, SODA/*苏打*/, SOAP/*香皂*/){}, //商品选项
    QUIT_TRANSACTION(ABORT_TRANSACTION){}, //退出交易
    SHUT_DOWN(STOP){}; //关闭
    private Input[] values;
    Category(Input... types) { values = types; }
    private static EnumMap<Input,Category> categories = new EnumMap<Input,Category>(Input.class);
    static {
        for(Category c : Category.class.getEnumConstants()) { //获取Category枚举类的所有实例，c是Category枚举类的一个实例
            for(Input type : c.values) { //type是c实例中成员变量values中的Input枚举类的一个实例
                categories.put(type, c); //以Input贩卖机输入指令为key，类目为value
            }
        }
    }
    public static Category categorize(Input input) {
        return categories.get(input);
    }
}
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/25
 */
public class VendingMachine { //贩卖机
    private static State state = State.RESTING; //贩卖机的状态，默认是休眠的
    private static int amount = 0; //金额
    private static Input selection = null; //选项
    enum StateDuration { TRANSIENT } // enum1:状态持续时间枚举
    enum State { // enum2:贩卖机的状态枚举
        RESTING { //休眠
            void next(Input input) {
                switch(Category.categorize(input)) { //根据输入指令取出对应的类目
                    case MONEY:   //如果输入的是金额选项，则增加金额，
                        amount += input.amount();
                        state = ADDING_MONEY; //贩卖机状态变为"投币状态"
                        break;
                    case SHUT_DOWN: //如果输入的是停止命令，则贩卖机状态变为"终止状态"
                        state = TERMINAL;
                    default:
                }
            }
        },
        ADDING_MONEY {  //投币状态
            void next(Input input) {
                switch(Category.categorize(input)) {
                    case MONEY:  //输入金额
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:  //输入选择商品指令
                        selection = input;
                        if(amount < selection.amount()) { //判断付出的金额和商品的金额
                            print("Insufficient money for " + selection); //付出的金额<商品金额 金额不足
                        } else {
                            state = DISPENSING; //付出的金额 > 商品金额 状态变更为"可取出商品状态"
                        }
                        break;
                    case QUIT_TRANSACTION: //如果是输入的"退出交易指令"
                        state = GIVING_CHANGE; //状态变更为"找钱，即将原来投进去的钱退出来"
                        break;
                    case SHUT_DOWN: //输入的关闭指定
                        state = TERMINAL; //状态变更为"终止状态"
                    default:
                }
            }
        },
        DISPENSING(StateDuration.TRANSIENT) { //可取出商品状态
            void next() {
                print("here is your " + selection); //这是你的商品选项
                amount -= selection.amount(); //扣除商品等价金额
                state = GIVING_CHANGE; //状态变更为"找零钱"
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) { //"找零钱状态"(注意因为这个枚举实例是用的带参构造器，所有它的isTransient=true)
            void next() {
                if(amount > 0) {
                    print("Your change: " + amount); //找零
                    amount = 0; //将机器里的金额置0
                }
                state = RESTING; //上面工作完成，状态变更为"休眠状态"
            }
        },
        TERMINAL { void output() { print("Halted"); } }; //终止状态
        private boolean isTransient = false; //枚举State用来判断是否是瞬时状态
        State() {}
        State(StateDuration trans) { isTransient = true; }
        void next(Input input) { //只允许非瞬时状态的输入指定调用该方法(因为只有非瞬时状态枚举实例会重写该方法)，否则就会抛异常
            throw new RuntimeException("Only call " + "next(Input input) for non-transient states");
        }
        void next() { //只允许瞬时状态的输入指令调用该方法(因为只有瞬时状态枚举实例会重写该方法)，否则就会抛异常
            throw new RuntimeException("Only call next() for " + "StateDuration.TRANSIENT states");
        }

        void output() { print(amount); }
    } //State枚举结束

    /**
     * 该方法永远不会停止，因为gen.next()不会返回stop命令
     * @param gen
     */
    static void run(Generator<Input> gen) {
        while(state != State.TERMINAL) { //状态不是终止，就一直进行
            Input input = gen.next();
            state.next(input); //执行下一步命令
            while(state.isTransient) { //如果枚举状态是瞬时的就执行下一步
                state.next();
            }
            state.output(); //状态输出
        }
    }

    public static void main(String[] args) {
        Generator<Input> gen = new RandomInputGenerator();
        if(args.length == 1) {
            gen = new FileInputGenerator(args[0]);
        }
        run(gen);
    }
} //VendingMachine结束




class RandomInputGenerator implements Generator<Input> {
    public Input next() {
        return Input.randomSelection();  //随机生成一个输入指令(但是不包括Stop)返回
    }
}

// Create Inputs from a file of ‘;’-separated strings:
class FileInputGenerator implements Generator<Input> {
    private Iterator<String> input;
    public FileInputGenerator(String fileName) {
        input = new TextFile(fileName, ";").iterator();
    }
    public Input next() {
        if(!input.hasNext()) {
            return null;
        }
        return Enum.valueOf(Input.class, input.next().trim());
    }
}
