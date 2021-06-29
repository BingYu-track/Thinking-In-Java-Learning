package annotations;
import com.sun.mirror.apt.*;
import com.sun.mirror.declaration.*;
import java.util.*;
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/28
 */
public class InterfaceExtractorProcessorFactory implements AnnotationProcessorFactory{

    /**
     * 获取注解处理器
     * @param atds 使用apt工具传入的java类
     * @param env
     * @return
     */
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> atds, AnnotationProcessorEnvironment env) {
        return new InterfaceExtractorProcessor(env);
    }

    public Collection<String> supportedAnnotationTypes() {
        return Collections.singleton("annotations.ExtractInterface");
    }

    public Collection<String> supportedOptions() {
        return Collections.emptySet();
    }
}
