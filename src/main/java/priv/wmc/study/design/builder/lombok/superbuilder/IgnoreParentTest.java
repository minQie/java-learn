package priv.wmc.study.design.builder.lombok.superbuilder;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 通过 @SuperBuilder 来获取一个会考虑父级字段的构建者
 * 一般这样的场景不多，即使有这样的场景，也不推荐使用 lombok 的实现性质的该注解
 * 这里仅作为参考学习：
 * 1、如果一个类希望使用 @SuperBuilder 则该类的所有父类都应该被 @SuperBuilder 修饰
 *
 * @author Wang Mincong
 * @date 2020-09-20 11:08:36
 */
@Slf4j
public class IgnoreParentTest {

    @Test
    public void test() {
        Duck duck = Duck.builder()
            .species("变异")
            .name("唐老鸭")
            .age(11)
            .build();
        log.info(duck.toString());
    }

}
