package priv.wmc.study.basic.number;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 下边的函数操作都是针对浮点数进行操作的
 * <p>ceil：向上取整
 * <p>round：四舍五入
 * <p>floor：向下取整
 *
 * @author Wang Mincong
 * @date 2020-07-21 20:38:04
 */
@Slf4j
public class MathTest {

    @Test
    public void test() {
        short s = 1;
        // 编译报错
//        s = s + 1;
        // 没有问题
        s += 1;

        short s2 = 1 + 1;
    }

    public void ceilTest() {
        // 2 向上取整ceil，参数需要严格为double数据类型的才能有效实现向上取整的效果，8/3得到的结果就是2
        int sum1 = (int) Math.ceil(8/3);
        log.info(String.valueOf(sum1));

        // 3
        int sum2 = (int) Math.ceil(8.0/3);
        log.info(String.valueOf(sum2));
    }

}