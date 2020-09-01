package priv.wmc.study.priority.proxy.jdk;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import priv.wmc.study.priority.proxy.DrinkInterface;
import priv.wmc.study.priority.proxy.EatInterface;
import priv.wmc.study.priority.proxy.EatInterfaceImpl;

/**
 * @author Wang Mincong
 * @date 2020-07-21 20:46:29
 */
@Slf4j
public class Demo {

    @Test
    public void test() {
        // 基本示例
//        basicDemo();
        // 特定接口示例
        specialDemo();
    }

    public void basicDemo() {
        Object proxy = JdkTargetProxy.newProxyInstance();

        // 调用目标对象被代理后的方法（代理对象的目标方法）
        EatInterface eatInterface = (EatInterface) proxy;
        log.info("==== 分割线 ====");
        eatInterface.eatRice();
        log.info("==== 分割线 ====");
        eatInterface.eatNoodles();

        DrinkInterface drinkInterface = (DrinkInterface) proxy;
        log.info("==== 分割线 ====");
        drinkInterface.drinkTea();
        log.info("==== 分割线 ====");
        drinkInterface.drinkJuice();
    }

    public void specialDemo() {
        EatInterface target = new EatInterfaceImpl();
        EatInterface proxy = JdkTargetProxy.getProxyInstance(target);

        // 调用目标对象被代理后的方法（代理对象的目标方法）
        log.info("==== 分割线 ====");
        proxy.eatRice();
        log.info("==== 分割线 ====");
        proxy.eatNoodles();
    }

}
