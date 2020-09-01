package priv.wmc.study.priority.reflect.enums;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-08-08 17:35:45
 */
@Slf4j
public class EnumReflectTest {

    @Test
    public void test() throws NoSuchFieldException {
        enumReflectDemo(ColorEnum.class);
    }

    /**
     * 这个泛型只能是 ? extends Enum<?> 而不能是 Enum<?> 的原因（泛型不具备多态的特性）
     *
     * {@link ColorEnum}
     * {@link priv.wmc.study.basic.generic.enum_test.EnumGenericConcept}
     * {@link priv.wmc.study.basic.extend.InvokerTypeDemo#example}
     */
    public void enumReflectDemo(Class<? extends Enum<?>> enumClass) throws NoSuchFieldException {
        for (Enum<?> i : enumClass.getEnumConstants()) {
            // 获取常量的变量名
            String enumName = i.name();
            // 获取常量上的注解
            Hello hello = enumClass.getField(enumName).getAnnotation(Hello.class);

            log.info(hello.value());
        }
    }

}
