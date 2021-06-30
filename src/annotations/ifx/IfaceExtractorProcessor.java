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
            String interfaceName = elem.getAnnotation(ExtractInterface.class).interfaceName();

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

    private void writeInterfaceFile(String interfaceName) {
        try(Writer writer = processingEnv.getFiler().createSourceFile(interfaceName).openWriter()) {
            String packageName = elementUtils.getPackageOf(interfaceMethods.get(0)).toString(); //获取包名
            writer.write("package " + packageName + ";\n");
            writer.write("public interface " + interfaceName + " {\n");
            for(Element elem : interfaceMethods) {
                ExecutableElement method = (ExecutableElement)elem;
                String signature = " public ";
                signature += method.getReturnType() + " ";
                signature += method.getSimpleName();
                signature += createArgList(method.getParameters());
                System.out.println(signature);
                writer.write(signature + ";\n");
            }
            writer.write("}");
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String createArgList(List<? extends VariableElement> parameters) {
        String args = parameters.stream().map(p -> p.asType() + " " + p.getSimpleName())
                .collect(Collectors.joining(", "));
        return "(" + args + ")";
    }


}
