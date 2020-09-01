package priv.wmc.study.basic.generic;

import java.util.List;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-07-28 21:47:02
 */
public class LimitExampleWhy {

    @Test
    public void test() {
        // 编译不通过
//        LimitExample.paramUpLimit(new Object());
        // 编译通过（原因是隐含者默认的类型转换）
        Object obj = LimitExampleWhy.returnUpLimit();
    }

    public static <T extends String> void paramUpLimit(T t) {}
    public static <T extends String> T returnUpLimit() {
        return null;
    }

    // 编译不通过？
//    public static <T super String> void downLimit() {}
    // 但是下面这样是编译通过的
    public static <T> void limitExample() {
        List<? extends T> upLimitList;
        List<? super T> downLimitList;
    }

    static class Parent {}
    static class Child extends Parent {}

}
