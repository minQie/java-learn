package priv.wmc.study.senior.proxy.jdk;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import priv.wmc.study.senior.proxy.DrinkInterface;
import priv.wmc.study.senior.proxy.EatAndDrinkInterfaceImpl;
import priv.wmc.study.senior.proxy.EatInterface;

/**
 * @author Wang Mincong
 * @date 2020-07-21 20:46:29
 */
@Slf4j
public class Demo<T extends EatInterface & DrinkInterface> {

    private static final String LOG_LINE_SEPARATOR = "==== 分割线 ====";

    @Test
    public void test() {
        basicDemo();
    }

    public void basicDemo() {
        // 将要被代理的对象
        EatAndDrinkInterfaceImpl target = new EatAndDrinkInterfaceImpl();

        // 代理对象
        /* 插曲：为什么不在{@link CustomJdkTargetProxy#newProxyInstances}方法中进行强转？
         *
         * 首先：在上述方法中强转为 T 类型，然后方法返回值类型也改为 T 类型，那么你就要在这里应该用什么类型去接收这个放回值呢？
         * （当然，用Object，然后需要用到哪个接口的类型，就强转为什么类型，这是完全没有问题的）
         * 或者：像当前类一样，当前类声明了与该方法返回值匹配的泛型，在下边用该泛型类型接口是可以的
         *
         * 注意：再创建一个接口类型，继承 T 泛型定义继承的两个类型，用这个类型去接收是不可以的
         * java.lang.ClassCastException: com.sun.proxy.$Proxy4 cannot be cast to priv.wmc.study.priority.proxy.CombineInterface
         */
        @SuppressWarnings("unchecked")
        T proxy = (T)CustomJdkTargetProxy.newProxyInstances(target);

        // 拿碗筷 吃 洗碗筷
        log.info(LOG_LINE_SEPARATOR);
        proxy.eatRice();
        log.info(LOG_LINE_SEPARATOR);
        proxy.eatNoodles();

        // 拿碗筷 喝 洗碗筷
        log.info(LOG_LINE_SEPARATOR);
        proxy.drinkTea();
        log.info(LOG_LINE_SEPARATOR);
        proxy.drinkJuice();
    }

}
