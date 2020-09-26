package priv.wmc.study.senior.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import lombok.extern.slf4j.Slf4j;
import priv.wmc.study.senior.proxy.DrinkInterface;
import priv.wmc.study.senior.proxy.EatInterface;

/**
 * jdk的动态代理：在内存中的运行时期动态的创建一个虚拟的代理对象
 * ps：web应用的示例，见项目“mynode”和“spring_learning”
 *
 * @author Wang Mincong
 * @date 2020-02-03 15:45
 */
@Slf4j
public final class CustomJdkTargetProxy {

    private static final String BEFORE_ADVICE = "拿碗和筷子";
    private static final String AFTER_ADVICE = "洗碗和筷子";

    private CustomJdkTargetProxy() {}

    public static EatInterface newProxyInstance(EatInterface target) {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] classArray = new Class[]{EatInterface.class};
        InvocationHandler handler = (proxy, method, args) -> {
            log.info(BEFORE_ADVICE);
            Object result = method.invoke(target, args);
            log.info(AFTER_ADVICE);
            return result;
        };
        return (EatInterface)Proxy.newProxyInstance(classLoader, classArray, handler);
    }

    public static DrinkInterface newProxyInstance(DrinkInterface target) {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] classArray = new Class[]{DrinkInterface.class};
        InvocationHandler handler = (proxy, method, args) -> {
            log.info(BEFORE_ADVICE);
            Object result = method.invoke(target, args);
            log.info(AFTER_ADVICE);
            return result;
        };
        return (DrinkInterface)Proxy.newProxyInstance(classLoader, classArray, handler);
    }

    /**
     * 为同时实现指定两个接口的实现类，创建代理对象
     */
    public static <T extends EatInterface & DrinkInterface> Object newProxyInstances(T target) {
        // 1、要代理的对象的 类加载器（？）
        ClassLoader classLoader = target.getClass().getClassLoader();
        // 2、要代理的对象的 接口字节码数组（会代理接口数组中的所有接口的所有方法）（必须是接口）
        Class<?>[] classArray = new Class[]{EatInterface.class, DrinkInterface.class};
        // 3、具体的代理过程
        // proxy Proxy.newProxyInstance的返回值，即代理对象
        // method 要代理的目标方法
        // args 要代理的目标方法的参数
        InvocationHandler handler = (proxy, method, args) -> {
            log.info(BEFORE_ADVICE);
            Object result = method.invoke(target, args);
            log.info(AFTER_ADVICE);
            return result;
        };

        return Proxy.newProxyInstance(classLoader, classArray, handler);
    }

}
