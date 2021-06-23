package enumerated.menu;

/**
 * @version 1.0
 * @Description: 使用接口组织枚举
 * @author: bingyu
 * @date: 2021/6/23
 */
public interface Food {
    enum Appetizer implements Food { //开胃菜
        SALAD, SOUP, SPRING_ROLLS;
    }
    enum MainCourse implements Food { //主菜
        LASAGNE, BURRITO, PAD_THAI,
        LENTILS, HUMMOUS, VINDALOO;
    }
    enum Dessert implements Food {
        TIRAMISU, GELATO, BLACK_FOREST_CAKE,
        FRUIT, CREME_CARAMEL;
    }
    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
        LATTE, CAPPUCCINO, TEA, HERB_TEA;
    }
}
