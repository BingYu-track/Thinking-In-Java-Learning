//: typeinfo/pets/PetCreator.java
// Creates random sequences of Pets.
package typeinfo.pets;
import java.util.*;

public abstract class PetCreator {
  private Random rand = new Random(47);

  //一个抽象方法，提供重写创建不同类型宠物的列表(这个列表中的类型已被定义为任何从Pet导出的类)，其它三个方法都是对这个抽象方法生成的Class列表进行操作
  public abstract List<Class<? extends Pet>> types();

  public Pet randomPet() { //该方法创建一个随机的宠物
    int n = rand.nextInt(types().size()); //随机产生list中的索引
    try {
      return types().get(n).newInstance(); //使用被随机选中的Class对象创建实例
    } catch(InstantiationException e) {
      throw new RuntimeException(e);
    } catch(IllegalAccessException e) { //IllegalAccessException：非法访问权限异常，这可能是因为类的构造器私有化导致的
      throw new RuntimeException(e);
    }
  }

  //该方法是使用上一个方法randomPet来填充数组
  public Pet[] createArray(int size) {
    Pet[] result = new Pet[size];
    for(int i = 0; i < size; i++)
      result[i] = randomPet();
    return result;
  }

  public ArrayList<Pet> arrayList(int size) {
    ArrayList<Pet> result = new ArrayList<Pet>();
    Collections.addAll(result, createArray(size)); //将所有指定元素添加到指定 collection result中
    return result;
  }

} ///:~
