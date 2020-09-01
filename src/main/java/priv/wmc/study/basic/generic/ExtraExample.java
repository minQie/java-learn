package priv.wmc.study.basic.generic;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 * <p>如果类似{@link #getOne(Set)}这样的方法，方法的返回值泛型由参数泛型类型，调用时动态决定
 * <p>因为jdk7新增的Diamond Operator，这样jvm在编译时期是无法获取具体的泛型类型的
 * <p>但是，开发者是可以指定的
 *
 * @author Wang Mincong
 * @date 2020-07-28 09:15:49
 */
public class ExtraExample {

    @Test
    public void test() {
        ExtraExample.getOne(new HashSet<>(16));
        Object obj = ExtraExample.getOne(new HashSet<>(16));

        // 下面两种方式都可以，指定特定的类型
        ExtraExample.<String>getOne(new HashSet<>(16));
        String str = ExtraExample.getOne(new HashSet<>(16));
    }

    public static <T> T getOne(Set<T> set) {
        return set.iterator().next();
    }

}
