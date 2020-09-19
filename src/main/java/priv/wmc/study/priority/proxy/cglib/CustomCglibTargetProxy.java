package priv.wmc.study.priority.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import priv.wmc.study.priority.proxy.DrinkInterface;
import priv.wmc.study.priority.proxy.EatInterface;

/**
 * @author 王敏聪
 * @date 2020-02-03 17:19
 */
@Slf4j
public final class CustomCglibTargetProxy {

    private static final String BEFORE_ADVICE = "拿碗和筷子";
    private static final String AFTER_ADVICE = "洗碗和筷子";

    private CustomCglibTargetProxy() {}

    public static EatInterface newProxyInstance(EatInterface target) {
        Enhancer en = new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback((MethodInterceptor) (proxyObj, method, args, methodProxy) -> {
            log.info(BEFORE_ADVICE);
            Object result = methodProxy.invokeSuper(proxyObj, args);
            log.info(AFTER_ADVICE);

            return result;
        });
        return (EatInterface)en.create();
    }

    public static EatInterface newProxyInstance(DrinkInterface target) {
        Enhancer en = new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback((MethodInterceptor) (proxyObj, method, args, methodProxy) -> {
            log.info(BEFORE_ADVICE);
            Object result = methodProxy.invokeSuper(proxyObj, args);
            log.info(AFTER_ADVICE);

            return result;
        });
        return (EatInterface)en.create();
    }

    public static <T extends EatInterface & DrinkInterface> Object newProxyInstances(T target) {
        // 代理对象实例
        Enhancer en = new Enhancer();
        // 设置要代理的类（不能是接口 - 即，不能写一个XxxInterface.class）
        en.setSuperclass(target.getClass());
        // 代理要做什么，MethodInterceptor是Callback的实现类
        en.setCallback((MethodInterceptor) (proxyObj, method, args, methodProxy) -> {
            // 前
            log.info(BEFORE_ADVICE);
            // ing
            Object result = methodProxy.invokeSuper(proxyObj, args);
            // 后
            log.info(AFTER_ADVICE);

            return result;
        });
        // 返回代理对象
        return en.create();
    }

}
