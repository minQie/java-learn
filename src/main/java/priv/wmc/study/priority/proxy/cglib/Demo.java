package priv.wmc.study.priority.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import priv.wmc.study.priority.proxy.EatInterface;
import priv.wmc.study.priority.proxy.EatInterfaceImpl;

/**
 * @author Wang Mincong
 * @date 2020-07-21 20:46:09
 */
@Slf4j
public class Demo {

    @Test
    public void test() {
        basicDemo();
    }

    public void basicDemo() {
        EatInterface target = new EatInterfaceImpl();
        Object proxy = CglibTargetProxy.getProxyInstance(target);

        EatInterface eatInterface = (EatInterface) proxy;
        log.info("==== 分割线 ====");
        eatInterface.eatRice();
        log.info("==== 分割线 ====");
        eatInterface.eatNoodles();
    }

}
