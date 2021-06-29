package annotations.simplest;
import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import java.util.*;
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/29
 */
@SupportedAnnotationTypes("annotations.simplest.Simple") //指定包的路径
@SupportedSourceVersion(SourceVersion.RELEASE_8) //选择java8的源代码版本
public class SimpleProcessor extends AbstractProcessor{


    //第一个参数告诉你哪个注解是存在的，第二个参数保留了剩余信息
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        for(TypeElement t : annotations) {
            System.out.println(t);
        }
        for(Element el : env.getElementsAnnotatedWith(Simple.class)) {
            display(el);
        }
        return false;
    }

    private void display(Element el) { //el.getModifiers()是否为 public 和 static 的
        System.out.println("==== " + el + " ====");
        System.out.println(el.getKind() +  //返回元素的类型
                " : " + el.getModifiers() +  //返回元素的修饰符
                " : " + el.getSimpleName() + //返回元素简单名称
                " : " + el.asType()); //返回由此元素定义的类型
        if(el.getKind().equals(ElementKind.CLASS)) {
            TypeElement te = (TypeElement)el; //TypeElement表示一个类或接口程序元素
            System.out.println(te.getQualifiedName());
            System.out.println(te.getSuperclass());
            System.out.println(te.getEnclosedElements()); //返回在此类或接口中直接声明的字段、方法、构造函数和成员类型。
        }
        if(el.getKind().equals(ElementKind.METHOD)) {
            ExecutableElement ex = (ExecutableElement)el; //ExecutableElement表示某个类或接口的方法、构造方法或初始化程序（静态或实例），包括注解类型元素
            System.out.print(ex.getReturnType() + " ");
            System.out.print(ex.getSimpleName() + "("); //返回方法名
            System.out.println(ex.getParameters() + ")"); //返回方法参数
        }
    }


}
