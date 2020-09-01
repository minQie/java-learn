package priv.wmc.study.priority.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import priv.wmc.study.priority.proxy.EatInterface;

/**
 * @author 王敏聪
 * @date 2020-02-03 17:19
 */
@Slf4j
public final class CglibTargetProxy {

    private CglibTargetProxy() {}

    public static EatInterface getProxyInstance(EatInterface eatInterface) {
        // 代理对象实例
        Enhancer en = new Enhancer();
        // 设置要代理的类（不能是接口）
        en.setSuperclass(eatInterface.getClass());
        // 代理要做什么，MethodInterceptor是Callback的实现类
        en.setCallback((MethodInterceptor) (proxyObj, method, args, methodProxy) -> {
            // 前
            log.info("拿碗和筷子");
            // ing
            Object result = methodProxy.invokeSuper(proxyObj, args);
            // 后
            log.info("洗碗和筷子");

            return result;
        });
        // 返回代理对象
        return (EatInterface)en.create();
    }

}
