package annotations;
import com.sun.mirror.apt.*;
import com.sun.mirror.declaration.*;
import java.io.*;
import java.util.*;
/**
 * @version 1.0
 * @Description: apt工具从jdk 1.7之后被废弃了，只能引入apt-mirror-api-0.1.jar，目前我是java8，如果引入tools.jar是会报错的，
 *    来自java编程思想第四版本，第五版本的请看simplest包下实现的注解处理器
 * @author: bingyu
 * @date: 2021/6/28
 */
public class InterfaceExtractorProcessor implements AnnotationProcessor{

    private final AnnotationProcessorEnvironment env;
    private ArrayList<MethodDeclaration> interfaceMethods = new ArrayList<MethodDeclaration>(); //用来保存方法的集合

    public InterfaceExtractorProcessor(AnnotationProcessorEnvironment env) {
        this.env = env;
    }

    public void process() {
        for(TypeDeclaration typeDecl : env.getSpecifiedTypeDeclarations()) { //通过env我们可以获取到类型
            ExtractInterface annot = typeDecl.getAnnotation(ExtractInterface.class);
            if(annot == null) {
                break;
            }
            for(MethodDeclaration m : typeDecl.getMethods()) {
                if(m.getModifiers().contains(Modifier.PUBLIC) && !(m.getModifiers().contains(Modifier.STATIC))) {
                    interfaceMethods.add(m);
                }
            }
            if(interfaceMethods.size() > 0) {
                try {
                    PrintWriter writer = env.getFiler().createSourceFile(annot.value());
                    writer.println("package " + typeDecl.getPackage().getQualifiedName() +";");
                    writer.println("public interface " + annot.value() + " {");
                    for(MethodDeclaration m : interfaceMethods) {
                        writer.print(" public ");
                        writer.print(m.getReturnType() + " ");
                        writer.print(m.getSimpleName() + " (");
                        int i = 0;
                        for(ParameterDeclaration parm : m.getParameters()) {
                            writer.print(parm.getType() + " " + parm.getSimpleName());
                            if(++i < m.getParameters().size()) {
                                writer.print(", ");
                            }
                        }
                        writer.println(");");
                    }
                    writer.println("}");
                    writer.close();
                } catch(IOException ioe) {
                    throw new RuntimeException(ioe);
                }
            }
        }
    }

}
