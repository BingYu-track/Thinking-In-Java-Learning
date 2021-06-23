package enumerated.menu;

/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/23
 */
public class Meal {

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            for(Course course : Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }
}
