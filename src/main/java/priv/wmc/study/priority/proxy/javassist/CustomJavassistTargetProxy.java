package priv.wmc.study.priority.proxy.javassist;

import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import priv.wmc.study.priority.proxy.EatInterface;
import priv.wmc.study.priority.proxy.EatInterfaceImpl;

/**
 * @author 王敏聪
 * @date 2020-02-06 16:42
 */
@Slf4j
public final class CustomJavassistTargetProxy {

    private CustomJavassistTargetProxy() {}

    @SneakyThrows
    public static EatInterface newProxyInstance() {
        ProxyFactory factory = new ProxyFactory();
        // 同cglib，下面必须是具体类，否则：
        // java.lang.RuntimeException: by java.lang.ClassFormatError: class priv.wmc.study.proxy.EatInterface_$$_jvstcc1_0 has interface priv.wmc.study.proxy.EatInterface as super class
        factory.setSuperclass(EatInterfaceImpl.class);

        // 设置具体要拦截Target目标类中的哪些方法
        factory.setFilter(method -> {
            //if (method.getName().equals("execute")) {
            return true;
            //}
            //return false;
        });

        EatInterface eatInterface = (EatInterface)factory.createClass().newInstance();
        ((ProxyObject)eatInterface).setHandler((self, thisMethod, proceed, args) -> {
            log.info("拿碗和筷子");
            Object result = proceed.invoke(self, args);
            log.info("洗碗和筷子");
            return result;
        });

        return eatInterface;
    }

}
