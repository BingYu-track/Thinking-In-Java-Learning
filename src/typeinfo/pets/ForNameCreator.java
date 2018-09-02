//: typeinfo/pets/ForNameCreator.java
package typeinfo.pets;
import java.util.*;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
    "typeinfo.pets.Mutt",
    "typeinfo.pets.Pug",
    "typeinfo.pets.EgyptianMau",
    "typeinfo.pets.Manx",
    "typeinfo.pets.Cymric",
    "typeinfo.pets.Rat",
    "typeinfo.pets.Mouse",
    "typeinfo.pets.Hamster"
  };
  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for(String name : typeNames){
        types.add(
          (Class<? extends Pet>)Class.forName(name) //这里需要转型
         );
      }
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  static {
    loader(); //静态初始化时调用loader方法 (注意这里要注意static语句的顺序，由于loader方法里用到了静态变量types和typeNames，为了避免空指针异常，该static语句
    //必须放在其它静态变量后面 )
  }

  public List<Class<? extends Pet>> types() {
    return types;
  }
} ///:~
