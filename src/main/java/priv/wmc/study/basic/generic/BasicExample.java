package priv.wmc.study.basic.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-08-31 18:51:20
 */
@Slf4j
public class BasicExample<T> {

    @Test
    public void test() {
        // 一、?，即无限制通配类型，编译器防止破坏集合的类型约束条件
        // 事实上，你无法将任何元素放进Collection<?>，要是你无法接收这样的限制：可以使用泛型方法或者有限制的通配符类型
//        Collection<?> collection = new ArrayList<>();
//        collection.add("123");

        // 二、本来说任何情况下，我们都不应该使用原生态类型，但有一例例外：必须在类文字（class literal）中使用原生态类型
//        List<String>.class

        // 三、
        // 运行时异常
//        Object[] objArray = new Long[2];
//        objArray[0] = "123";
        // 编译时异常
//        List<Object> objList = new ArrayList<Long>();
//        objList.add("123");
    }

    // 四、
    public void test1(Object obj) {
        if (obj instanceof Set) {
            // 进入到if中说明，obj是Set类型，必须将其转成通配符类型
            // 这是受检的转换，因此不会导致编译时警告
            // 使用原生态类型，会在运行时导致异常，因此不要使用
            Set<?> set = (Set<?>) obj;
            log.info(String.valueOf(set.size()));
        }
    }

    // 五、super 不能用于泛型声明
    // public class Xxx<T super String>
    // public static <T super Xxx> void func(T t)

    // super的应用场景？
    //
    public static <T> void a(List<? super String> list) {
        List<? super T> a = new ArrayList<>();
    }

    // 六、
    public static <T> T fun(T t1, T t2) {
        return t1;
    }
    public static void funTest() {
        // 判定 T 为 Serializable & Comparable<? extends Serializable & Comparable<?>>
        fun("123", 1);
        // 莫得办法，判定 T 为 Object
        fun("123", new BasicExample());
    }
}
