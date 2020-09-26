package priv.wmc.study.design.builder.lombok.builder;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 一、lombok 的 @Builder 不理会父级的属性
 * 二、参照 @Builder 源码上的注释
 * （注解 @Builder 相当于包含了 @AllArgsConstructor(access = AccessLevel.PRIVATE)）
 * 希望使用使用 lombok 提供的构建者模式的实现，使用需要注意：
 * 1、不能自定义任何 构造函数
 * 2、不能使用任何 @XArgsConstructor
 *
 * @author Wang Mincong
 * @date 2020-09-20 11:08:36
 */
@Slf4j
public class IgnoreParentTest {

    @Test
    public void test() {
        // 无法设置父类的属性
        Duck dock = Duck.builder()
            .species("唐老鸭")
            .build();
        log.info(dock.toString());
    }

}
