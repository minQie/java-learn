package priv.wmc.study.design.builder.custom.impl_one;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-09-20 11:59:42
 */
@Slf4j
public class BuilderTest {

    @Test
    public void test() {
        Animal animal = Animal.builder()
            .name("动物")
            .age(100)
            .build();
        log.info(animal.toString());

        Duck duck = Duck.builder()
            .species("唐老鸭")
            .name("唐唐")
            .age(11)
            .build();
        log.info(duck.toString());
    }

}
