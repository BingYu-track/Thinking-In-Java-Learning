package enumerated.menu;
import static enumerated.menu.Food.*;
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/23
 */
public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Appetizer.SALAD;
        food = MainCourse.LASAGNE;
        food = Dessert.GELATO;
        food = Coffee.CAPPUCCINO;
    }
}
