package priv.wmc.study.priority.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import lombok.extern.slf4j.Slf4j;
import priv.wmc.study.priority.proxy.EatInterface;
import priv.wmc.study.priority.proxy.Target;

/**
 * jdk的动态代理：在内存中的运行时期动态的创建一个虚拟的代理对象
 * ps：web应用的示例，见项目“mynode”和“spring_learning”
 *
 * @author 王敏聪
 * @date 2020-02-03 15:45
 */
@Slf4j
public final class JdkTargetProxy {

    private JdkTargetProxy() {}

    /**
     * 实例1 - 基本示例 针对特定的接口（EatInterface）的实现类，生成代理对象
     */
    public static Object newProxyInstance() {
        // 一、要代理的目标对象 - 新建一个
        Target target = new Target();

        // 二、生成目标对象的代理对象
        // 1、要代理的对象的 类加载器（？）
        ClassLoader classLoader = target.getClass().getClassLoader();
        // 2、要代理的对象的 接口字节码数组（会代理接口数组中的所有接口的所有方法）（必须是接口）
        Class<?>[] classArray = Target.class.getInterfaces();
        // 3、具体的代理过程
        // proxy Proxy.newProxyInstance的返回值，即代理对象
        // method 要代理的目标方法
        // args 要代理的目标方法的参数
        InvocationHandler handler = (proxy, method, args) -> {
            log.info("拿碗和筷子");
            Object result = method.invoke(target, args);
            log.info("洗碗和筷子");
            return result;
        };
        return Proxy.newProxyInstance(classLoader, classArray, handler);
    }

    /**
     * 实例2 - 针对特定的接口类型（EatInterface），生成代理对象
     */
    public static EatInterface getProxyInstance(EatInterface eatInterface) {
        ClassLoader classLoader = eatInterface.getClass().getClassLoader();
        Class<?>[] classArray = new Class[] {EatInterface.class};
        InvocationHandler handler = (proxy, method, args) -> {
            log.info("拿碗和筷子");
            Object result = method.invoke(eatInterface, args);
            log.info("洗碗和筷子");

            return result;
        };
        return (EatInterface)Proxy.newProxyInstance(classLoader, classArray, handler);
    }

}
