package annotations.ifx;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/30
 */
@SupportedAnnotationTypes("annotations.ifx.ExtractInterface")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class IfaceExtractorProcessor extends AbstractProcessor {

    private ArrayList<Element> interfaceMethods = new ArrayList<>();

    Elements elementUtils; //是一个静态工具的集合；我们使用它来查找writeInterfaceFile()方法中的包名称

    private ProcessingEnvironment processingEnv;

    @Override
    public void init(ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
        elementUtils = processingEnv.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        for(Element elem:env.getElementsAnnotatedWith(ExtractInterface.class)) {
            String interfaceName = elem.getAnnotation(ExtractInterface.class).interfaceName(); //接口名，在这里是Multiplier类上注解的IMultiplier

            for(Element enclosed : elem.getEnclosedElements()) { //获取私有的元素
                    //getModifiers()方法返回这个元素所有的修饰符Set集合
                if(enclosed.getKind().equals(ElementKind.METHOD) && enclosed.getModifiers().contains(Modifier.PUBLIC) &&
                        !enclosed.getModifiers().contains(Modifier.STATIC)) { //如果是公共非静态的方法，就存放到interfaceMethods
                    interfaceMethods.add(enclosed);
                }
            }
            if(interfaceMethods.size() > 0) { //如果有公共方法，就将其写入接口文件中
                writeInterfaceFile(interfaceName);
            }


        }
        return false;
    }

    /**
     *
     * @param interfaceName 接口名
     */
    private void writeInterfaceFile(String interfaceName) {
        try(Writer writer = processingEnv.getFiler().createSourceFile(interfaceName).openWriter()) {
            String packageName = elementUtils.getPackageOf(interfaceMethods.get(0)).toString(); //获取包名
            System.out.println("包名: "+packageName);
            writer.write("package " + packageName + ";\n");
            writer.write("public interface " + interfaceName + " {\n");
            for(Element elem : interfaceMethods) {
                ExecutableElement method = (ExecutableElement)elem; //将Element向下转型为ExecutableElement，它可以提取所有的方法信息
                String signature = " public ";
                signature += method.getReturnType() + " ";
                signature += method.getSimpleName();
                signature += createArgList(method.getParameters()); //
                System.out.println(signature);
                writer.write(signature + ";\n");
            }
            writer.write("}");
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    //生成方法的参数列表
    private String createArgList(List<? extends VariableElement> parameters) {
        String args = parameters.stream().map(p -> p.asType() + " " + p.getSimpleName())
                .collect(Collectors.joining(", "));
        return "(" + args + ")";
    }


    //javac -encoding UTF-8 IfaceExtractorProcessor.java

    //问题1:
    /*
    > src/annotations/ifx java IfaceExtractorProcessor
    错误: 找不到或无法加载主类 IfaceExtractorProcessor
    因为执行时一个类的全名应该是包名+类名，执行时也是一样，不能仅仅只在java命令后面用类名


    > src/annotations/ifx java annotations.ifx.IfaceExtractorProcessor
    错误: 找不到或无法加载主类 annotations.ifx.IfaceExtractorProcessor
    这是因为我们在src/annotations/ifx目录下执行，其实它找的类路径是src/annotations/ifx/annotations/ifx


    因此你执行后面这个命令就不会成功javac -processor annotations.ifx.IfaceExtractorProcessor -encoding UTF-8 Multiplier.java
    在src/annotations/ifx目录执行,报找不到注解处理程序 'annotations.ifx.IfaceExtractorProcessor'
    目前不明白作者用javac -processor annotations.ifx.IfaceExtractorProcessor Multiplier.java命令是怎么执行成功的
javac -processor IfaceExtractorProcessor -encoding UTF-8 Multiplier.java

    问题2(在src/annotations/ifx目录下创建了annotations.ifx包路径后再执行):
    > src/annotations/ifx javac -processor annotations.ifx.IfaceExtractorProcessor -encoding UTF-8 Multiplier.java
    报错Multiplier.java:9: 错误: 找不到符号
    @ExtractInterface(interfaceName="IMultiplier")
     ^

    唯一能行得通的是在src目录下执行
    javac -processor annotations.ifx.IfaceExtractorProcessor -encoding UTF-8 D:/Eclipse_Code/src/annotations/ifx/Multiplier.java
    会在src目录下生成IMultiplier.java文件,目前这个接口文件已被我手动移动到src/annotations/ifx目录下


    javac -cp ./ -processor IfaceExtractorProcessor -encoding UTF-8 Multiplier.java

     */

    /**
     输出:
     public int multiply(int x, int y)
     public int fortySeven()
     public double timesTen(double arg)
     */

}
