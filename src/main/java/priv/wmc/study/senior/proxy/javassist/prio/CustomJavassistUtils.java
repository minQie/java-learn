package priv.wmc.study.senior.proxy.javassist.prio;

import java.util.Arrays;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

/**
 * @author Wang Mincong
 * @date 2020-07-18 20:16:24
 */
public final class CustomJavassistUtils {

    private CustomJavassistUtils() {}

    public static CtClass[] toCtClass(ClassPool classPool, Class<?>[] classes) {
        return Arrays.stream(classes)
            .map(clazz -> {
                try {
                    return classPool.get(clazz.getName());
                } catch (NotFoundException e) {
                    throw new RuntimeException(e);
                }
            }).toArray(CtClass[]::new);
    }

}
