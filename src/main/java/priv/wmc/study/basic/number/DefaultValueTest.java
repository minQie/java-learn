package priv.wmc.study.basic.number;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-09-04 09:41:15
 */
@Slf4j
public class DefaultValueTest {

    /**
     * 成员变量：int类型的变量不指定初始值，在创建对象 初始化时，jvm将其默认设置为0
     * 局部变量：int类型的变量不指定初始值，不能使用（编译错误）
     */
    @Test
    public void test() {
        System.out.println(new Object() {
            int sum;
        }.sum);

        System.out.println(new Object() {
            Integer sum;
        }.sum);
    }

}
