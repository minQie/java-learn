package priv.wmc.study.senior.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import priv.wmc.study.senior.proxy.DrinkInterface;
import priv.wmc.study.senior.proxy.EatAndDrinkInterfaceImpl;
import priv.wmc.study.senior.proxy.EatInterface;
import priv.wmc.study.senior.proxy.EatInterfaceImpl;

/**
 * @author Wang Mincong
 * @date 2020-07-21 20:46:09
 */
@Slf4j
public class Demo<T extends EatInterface & DrinkInterface> {

    private static final String LOG_LINE_SEPARATOR = "==== 分割线 ====";

    @Test
    public void test() {
//        basicDemo();
        test1();
    }

    public void basicDemo() {
        EatInterface target = new EatInterfaceImpl();
        EatInterface proxy = CustomCglibTargetProxy.newProxyInstance(target);

        log.info(LOG_LINE_SEPARATOR);
        proxy.eatRice();
        log.info(LOG_LINE_SEPARATOR);
        proxy.eatNoodles();
    }

    public void test1() {
        EatAndDrinkInterfaceImpl target = new EatAndDrinkInterfaceImpl();

        @SuppressWarnings("unchecked")
        T proxy = (T) CustomCglibTargetProxy.newProxyInstances(target);

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
