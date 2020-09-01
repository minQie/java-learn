package priv.wmc.study.priority.proxy.javassist;

import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import lombok.extern.slf4j.Slf4j;
import priv.wmc.study.priority.proxy.EatInterface;
import priv.wmc.study.priority.proxy.EatInterfaceImpl;

/**
 * @author 王敏聪
 * @date 2020-02-06 16:42
 */
@Slf4j
public final class JavassistTargetProxy {

    private JavassistTargetProxy() {}

    public static Object newProxyInstance() {
        ProxyFactory factory = new ProxyFactory();
        // 下面必须是具体类，否报如下错误
        // java.lang.RuntimeException: by java.lang.ClassFormatError: class priv.wmc.study.proxy.EatInterface_$$_jvstcc1_0 has interface priv.wmc.study.proxy.EatInterface as super class
        factory.setSuperclass(EatInterfaceImpl.class);
        factory.setFilter(method -> {
            //if (method.getName().equals("execute")) {
            return true;
            //}
            //return false;
        });

        EatInterface eatInterface = null;
        try {
            eatInterface = (EatInterface)factory.createClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        ((ProxyObject)eatInterface).setHandler((self, thisMethod, proceed, args) -> {
            log.info("拿碗和筷子");
            Object result = proceed.invoke(self, args);
            log.info("洗碗和筷子");
            return result;
        });

        return eatInterface;
    }

}
