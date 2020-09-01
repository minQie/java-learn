package priv.wmc.study.priority.reflect.generic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-08-08 22:42:33
 */
@Slf4j
public class GetClassGenericExample<T> {

    @Test
    public void test() {
        // 获取当前对象类上泛型的实际类型
//        Type genericSuperclass = this.getClass().getGenericSuperclass();
        // 获取当前对象类上实现的接口中带泛型的接口类型
//        Type[] genericInterfaces = this.getClass().getGenericInterfaces();
    }

}
