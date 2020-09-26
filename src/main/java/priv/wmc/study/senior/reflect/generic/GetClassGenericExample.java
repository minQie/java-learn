package priv.wmc.study.senior.reflect.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 获取当前对象类上泛型的实际类型（如果本类没有泛型，但是父类有，下面的方法获取到的就是父类类型，例如：Parent<java.lang.String>）
 *    Type genericSuperclass = this.getClass().getGenericSuperclass();
 * 获取当前对象类上实现的接口中带泛型的接口类型
 *    Type[] genericInterfaces = this.getClass().getGenericInterfaces();
 *
 * @author Wang Mincong
 * @date 2020-08-08 22:42:33
 */
@Slf4j
public class GetClassGenericExample<T> {

    private static class Parent<K> {}

    private static class Child<Q> extends Parent<String> {}

    private static void getClassGenericRuntimeType(Object object) {
        ParameterizedType genericSuperclass = (ParameterizedType) object.getClass().getGenericSuperclass();
        Type actualTypeArgument = genericSuperclass.getActualTypeArguments()[0];
        log.info(actualTypeArgument.getTypeName());
    }

    @Test
    public void test() {
        // 无法获取到泛型在运行时期的具体类型
//        getClassGenericRuntimeType(new GetClassGenericExample<String>());
//        getClassGenericRuntimeType(new Parent<String>());

        // 能够获取到泛型在运行时期的具体类型（Child类定义的泛型Q就是一个幌子）
        getClassGenericRuntimeType(new Child<Long>());

        // 根据测试的现象，如果希望能够获取到泛型在运行时期的具体类型，则必须是通过类声明的静态定义
        // 所以如果希望上面的Parent一定能够获取到泛型在运行时期的具体类型，可以将Parent声明为抽象类
    }

}
