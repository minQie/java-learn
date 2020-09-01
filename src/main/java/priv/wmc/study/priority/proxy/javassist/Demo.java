package priv.wmc.study.priority.proxy.javassist;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import priv.wmc.study.priority.proxy.EatInterface;

/**
 * @author Wang Mincong
 * @date 2020-07-21 20:47:04
 */
@Slf4j
public class Demo {

    @Test
    public void test() {
        basicDemo();
    }
    
    public void basicDemo() {
        Object proxy = JavassistTargetProxy.newProxyInstance();
        
        EatInterface eatInterface = (EatInterface) proxy;
        log.info("==== 分割线 ====");
        eatInterface.eatRice();
        log.info("==== 分割线 ====");
        eatInterface.eatNoodles();
    }
    
}
