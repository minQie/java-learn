package priv.wmc.study.design.builder.custom.first_flawed;

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
        // 这样构建出来的对象是合格的，但是如下的不合理或者说弊端
        // 1、返回值类型只能是 Animal 父类 而不能落实到具体的子类
        // 2、子类相较于父类独有的属性，在构建种只能先赋值，否则无法赋值
        Animal duck = Duck.builder()
            .species("唐老鸭")
            .name("唐唐")
            .age(11)
            .build();

        log.info(duck.toString());
    }

}
