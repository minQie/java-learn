package priv.wmc.study.senior.proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import priv.wmc.study.senior.proxy.cglib.CustomCglibTargetProxy;
import priv.wmc.study.senior.proxy.javassist.CustomJavassistTargetProxy;
import priv.wmc.study.senior.proxy.jdk.CustomJdkTargetProxy;

/**
 * <p>jdk - 接口
 * <p>cglib - 具体类（原理是通过产生目标类的继承类实现的）
 * <p>javassist - 具体类（原理是通过产生目标类的继承类实现的）
 *
 * @author Wang Mincong
 * @date 2020-02-04 20:41
 */
@Slf4j
public class DifferenceDemo {

    @Test
    public void test() {
        test1();
//        test2();
    }

    public void test1() {
        EatInterface target = new EatInterfaceImpl();

        Object proxyByJdk = CustomJdkTargetProxy.newProxyInstance(target);
        Object proxyByCglib = CustomCglibTargetProxy.newProxyInstance(target);
        Object proxyByJavassist = CustomJavassistTargetProxy.newProxyInstance();

        log.info("jdk       proxy is aim interface type: " + (proxyByJdk instanceof EatInterface));
        log.info("cglib     proxy is aim interface type: " + (proxyByJdk instanceof EatInterface));
        log.info("javassist proxy is aim interface type: " + (proxyByJavassist instanceof EatInterface));

        log.info("jdk       proxy is target's super class: " + (proxyByJdk instanceof EatInterfaceImpl));
        log.info("cglib     proxy is target's super class: " + (proxyByCglib instanceof EatInterfaceImpl));
        log.info("javassist proxy is target's super class: " + (proxyByJavassist instanceof EatInterfaceImpl));
    }

    public void test2() {
        EatAndDrinkInterfaceImpl target = new EatAndDrinkInterfaceImpl();

        Object proxyByJdk = CustomJdkTargetProxy.newProxyInstances(target);
        Object proxyByCglib = CustomCglibTargetProxy.newProxyInstances(target);

        log.info("jdk   proxy is aim interface type: " + (proxyByJdk instanceof EatInterface && proxyByJdk instanceof DrinkInterface));
        log.info("cglib proxy is aim interface type: " + (proxyByJdk instanceof EatInterface && proxyByJdk instanceof DrinkInterface));

        log.info("jdk   proxy is target's super class: " + (proxyByJdk instanceof EatAndDrinkInterfaceImpl));
        log.info("cglib proxy is target's super class: " + (proxyByCglib instanceof EatAndDrinkInterfaceImpl));
    }

}
