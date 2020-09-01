package priv.wmc.study.priority.reflect.generic;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

/**
 * @author Wang Mincong
 * @date 2020-08-08 22:40:29
 */
@Slf4j
public class GetMethodParamGenericExample {

    @Test
    public void test() {
//        GetMethodParamGenericExample.getParamActuallyGenericType("1");

//        GetMethodParamGenericExample.getCollectionParamActuallyGenericType(Arrays.asList("1", "2"));

        getReturnGenericType();
    }

    /**
     * 像这样的待定泛型，本来就是只能在运行时确定类型
     */
    public static <T> void getParamActuallyGenericType(@NonNull T t) {
        if (t == null) {
            Assert.notNull(t, "参数为null，没得办法判断");
        }

        log.info("普通泛型参数方法，泛型：{}", t.getClass().toString());
    }

    /**
     * 像这样的待定泛型，本来就是只能在运行时确定类型
     *
     * 只有这一种方法，想获取List运行时泛型，除了根据集合中的元素，是没有其他方法的
     * 原因：这正是泛型擦除带来的不便，要是设计初期就考虑了泛型，那么就不会采取编译时期的泛型擦除来适配之前的设计了
     */
    public static <T> void getCollectionParamActuallyGenericType(Collection<T> collection) {
        if (CollectionUtils.isEmpty(collection)) {
            Assert.notNull(collection, "空集合，没得办法判断");
        }
        log.info("集合泛型参数方法，泛型：{}", collection.iterator().next().getClass().toString());
    }

    /**
     * 如果泛型是确定的，是完全可以通过反射直接获取到的
     */
    @SneakyThrows
    public static List<String> getReturnGenericType() {
        Method method = GetMethodParamGenericExample.class.getMethod("getReturnGenericType");

        // 返回值类型（不带泛型）
        Type returnType = method.getGenericReturnType();
        // 返回值类型（带泛型）
        Type genericReturnType = method.getGenericReturnType();

        if (genericReturnType instanceof ParameterizedType) {
            Type type = ((ParameterizedType) genericReturnType).getActualTypeArguments()[0];
            log.info("普通泛型参数方法，泛型：{}", type.toString());
        }

        return null;
    }

}
