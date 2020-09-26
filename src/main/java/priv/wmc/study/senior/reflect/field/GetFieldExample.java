package priv.wmc.study.senior.reflect.field;

import java.lang.reflect.Field;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * <h2>getField</h2>
 * <p>属性必须被public修饰，并且会从父类中查找（递归直至Object）</p>
 *
 * <h2>getDeclaredField</h2>
 * <p>无视权限修饰符，但不会从父类中查找</p>
 *
 * @author Wang Mincong
 * @date 2020-08-08 17:57:52
 */
@Slf4j
public class GetFieldExample {

    @Test
    public void test() {
        Field[] fields = Child.class.getFields();
        log.info("getFields.........");
        for (Field field : fields) {
            log.info(field.getName());
        }

        log.info("getDeclaredFields.........");
        Field[] declaredFields = Child.class.getDeclaredFields();
        for (Field field : declaredFields) {
            log.info(field.getName());
        }
    }

}
