package priv.wmc.study.basic.deliver;

import java.lang.reflect.Field;
import lombok.SneakyThrows;
import org.junit.Test;

/**
 * 在{@link BasicTest}中，将值传递和引用传递的概念，以及java是名副其实的值传递解释的很清楚
 *
 * 而当前测试类，主要是从下面几点出发提出的：
 * 1、基础数据类型的包装数据类型理论上是能够修改值的（得到验证）
 * 2、基于java值传递的概念，进一步了解清楚java的自动拆装箱
 *
 * @author Wang Mincong
 * @date 2020-09-04 16:13:42
 */
public class SpecialTest {

    @Test
    public void demo() {
        int sum1 = 0;
        Integer sum2 = 0;
        changeValue(sum1);
        changeValue(sum2);
        System.out.println("sum1=" + sum1);
        System.out.println("sum2=" + sum2);
    }

    @SneakyThrows
    private void changeValue(Integer sum) {
        Field value = Integer.class.getDeclaredField("value");
        value.setAccessible(true);
        value.set(sum, 1);
    }

}
