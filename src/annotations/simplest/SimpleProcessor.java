package annotations.simplest;
import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import java.util.*;
/**
 * @version 1.0
 * @Description: 使用javac处理处理注解
 * @author: bingyu
 * @date: 2021/6/29
 */
@SupportedAnnotationTypes({"annotations.simplest.Simple"}) //@SupportedAnnotationTypes用于指定注解处理器要处理的注解类型
@SupportedSourceVersion(SourceVersion.RELEASE_8) //选择java8的源代码版本
public class SimpleProcessor extends AbstractProcessor{


    //第一个参数告诉你哪个注解是存在的，第二个参数保留了剩余信息，你可以在这个方法里面编码实现扫描，处理注解，生成 java 文件
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        for(TypeElement t : annotations) {
            System.out.println(t);
        }
        for(Element el : env.getElementsAnnotatedWith(Simple.class)) { //循环每一个被@Simple注解的元素，并调用display方法
            display(el);
        }
        return false;
    }

    private void display(Element el) { //el是被@Simple注解的元素
        System.out.println("==== " + el + " ====");
        System.out.println(el.getKind() +  //返回元素的类型
                " : " + el.getModifiers() +  //返回元素的修饰符 el.getModifiers()是否为 public 和 static 的
                " : " + el.getSimpleName() + //返回元素简单名称
                " : " + el.asType()); //返回由此元素定义的类型
        if(el.getKind().equals(ElementKind.CLASS)) { //如果被@Simple注解的元素是一个类
            TypeElement te = (TypeElement)el; //TypeElement表示一个类或接口程序元素
            System.out.println(te.getQualifiedName());
            System.out.println(te.getSuperclass());
            System.out.println(te.getEnclosedElements()); //返回在此类或接口中直接声明的字段、方法、构造函数和成员类型。
        }
        if(el.getKind().equals(ElementKind.METHOD)) { //如果被@Simple注解的元素是一个方法
            ExecutableElement ex = (ExecutableElement)el; //ExecutableElement表示某个类或接口的方法、构造方法或初始化程序（静态或实例），包括注解类型元素
            System.out.print(ex.getReturnType() + " ");
            System.out.print(ex.getSimpleName() + "("); //返回方法名
            System.out.println(ex.getParameters() + ")"); //返回方法参数
        }
    }

    /**
     通过 javac，你可以通过创建编译时（compile-time）注解处理器在 Java 源文件上使用注解
     每一个你编写的注解都需要处理器，但是 javac 可以非常容易的将多个注解处理器合并在一起。
     你可以指定多个需要处理的类，并且你可以添加监听器用于监听注解处理完成后接到通知
     */

    //javac -processor annotations.simplest.SimpleProcessor SimpleTest.java
    //javac -processor annotations.simplest.SimpleProcessor -encoding UTF-8 d:\Eclipse_Code\src\annotations\simplest\SimpleTest.java
    //要把处理的注解simple.class文件和注解处理器的SimpleProcessor.class文件放在当前执行命令目录下才能正常执行命令
/*
==== annotations.simplest.SimpleTest ====
    CLASS : [public] : SimpleTest : annotations.simplest.SimpleTest
    annotations.simplest.SimpleTest
    java.lang.Object
    i,SimpleTest(),foo(),bar(java.lang.String,int,float),main(java.lang.String[])
            ==== i ====
    FIELD : [] : i : int
==== SimpleTest() ====
    CONSTRUCTOR : [public] : <init> : ()void
==== foo() ====
    METHOD : [public] : foo : ()void
    void foo()
==== bar(java.lang.String,int,float) ====
    METHOD : [public] : bar : (java.lang.String,int,float)void
    void bar(s,i,f)
==== main(java.lang.String[]) ====
    METHOD : [public, static] : main : (java.lang.String[])void
    void main(args)
    */
}
