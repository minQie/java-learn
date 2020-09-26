package priv.wmc.study.senior.proxy.javassist;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import priv.wmc.study.senior.proxy.EatInterface;

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
        // EatInterfaceImpl 的 proxy
        EatInterface proxy = CustomJavassistTargetProxy.newProxyInstance();
        
        log.info("==== 分割线 ====");
        proxy.eatRice();
        log.info("==== 分割线 ====");
        proxy.eatNoodles();
    }
    
}
