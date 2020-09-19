package priv.wmc.study.basic.deliver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * <p>针对这样的提问：java中是值传递还是引用传递？
 * <p>首先，你需要理解好这个问题，而不是直接上java的代码测试，这样即使你是原理都清楚的，但是你是答不好的
 *
 * <p>值传递：跳到下面的原理去看
 * <p>引用传递：在调用函数时将实际参数的地址传递到函数中，那么在函数中对参数所进行的修改，将影响到实际参数（百度百科）
 * <p>ps：C语言默认是值传递，但是也提供了引用传递的方式："int& i" 或 "int &i"都行
 *
 * <p>原理：java中是值传递：即在方法栈中创建与入参相同类型的变量，将入参的值赋值给这个变量，所以在方法中无论你怎么操作修改这个变量，都不会影响入参变量的值。
 * 没错，上面已经完全足够阐述java是值传递的了。如果方法的参数类型是对象，那么值传递的效果是这样的，入参和方法中局部变量都指向了堆中的同一个对象
 * 像这样偷换概念，起到间接修改入参的效果，经常迷惑java开发人员，误以为java是引用传递
 *
 * @author Wang Mincong
 * @date 2020-09-04 18:36:04
 */
@Slf4j
public class BasicTest {

    @Test
    public void test() {
        // 虽说 一 和 二 是根据方法名区分的，但是将basicTypeDeliver1 2统一命名为basicTypeDeliver，jvm也是能够根据参数类型进行调用的
        // 一、基础数据类型
        int sum1 = 0;

        basicTypeDeliver1(sum1);
        log.info(String.valueOf(sum1));
        basicTypeDeliver2(sum1);
        log.info(String.valueOf(sum1));

        // 二、包装数据类型测试
        Integer sum2 = 0;

        basicTypeDeliver1(sum2);
        log.info(String.valueOf(sum2));
        basicTypeDeliver2(sum2);
        log.info(String.valueOf(sum2));

        // 三、对象 - 展示java是值引用的关键
        Inner inner = new Inner("0");

        quotaTypeDeliverChangeQuota(inner);
        log.info(String.valueOf(inner == null));
        quotaTypeDeliverChangeProperty(inner);
        log.info(inner.property);
    }

    public void basicTypeDeliver1(int sum) {
        log.info("param type int run");
        sum = 1;
    }
    public void basicTypeDeliver2(Integer sum) {
        log.info("param type Integer run");
        sum = 1;
    }

    public void quotaTypeDeliverChangeQuota(Inner inner) {
        inner = null;
    }
    public void quotaTypeDeliverChangeProperty(Inner inner) {
        inner.property = "1";
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private static class Inner {
        private String property;
    }

}
