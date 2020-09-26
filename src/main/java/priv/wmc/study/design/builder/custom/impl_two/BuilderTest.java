package priv.wmc.study.design.builder.custom.impl_two;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 限定父级以及父级的构建器只用作高级抽象层次的定义，不能实例化
 *
 * @author Wang Mincong
 * @date 2020-09-20 11:59:42
 */
@Slf4j
public class BuilderTest {

    @Test
    public void test() {
        Duck duck = Duck.builder()
            .species("唐老鸭")
            .name("唐唐")
            .age(11)
            .build();
        log.info(duck.toString());
    }

}
