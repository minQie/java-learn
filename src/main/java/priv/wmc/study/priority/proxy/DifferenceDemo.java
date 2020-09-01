package priv.wmc.study.priority.proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import priv.wmc.study.priority.proxy.cglib.CglibTargetProxy;
import priv.wmc.study.priority.proxy.jdk.JdkTargetProxy;

/**
 * 核心类型设置
 * jdk - 接口
 * cglib - 具体类（原理是通过产生目标类的继承类实现的）
 * javassist - 具体类
 *
 * @author 王敏聪
 * @date 2020-02-04 20:41
 */
@Slf4j
public class DifferenceDemo {

    @Test
    public void test() {
        EatInterface target = new EatInterfaceImpl();

        Object proxy = JdkTargetProxy.getProxyInstance(target);
        log.info("jdk: " + (proxy instanceof EatInterfaceImpl));

        proxy = CglibTargetProxy.getProxyInstance(target);
        log.info("cglib: " + (proxy instanceof EatInterfaceImpl));
    }

}
