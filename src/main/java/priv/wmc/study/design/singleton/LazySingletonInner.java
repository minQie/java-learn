package priv.wmc.study.design.singleton;

/**
 * 懒汉式单例实现：静态内部类
 *
 * 核心：利用了classloader的机制来保证初始化 instance 时只有一个线程，并且只有加载好了（发生重排序也得都执行好了），才能提供给其他线程使用
 *
 * 疑点：这个为什么是懒汉式？（在私有构造里边加上一条日志，就可以验证是否时懒汉式了）
 *
 * 明确：JVM的类加载机制，不牵涉到具体的ClassLoader
 * 明确：要清楚 静态 != 一定会加载，实际还是使用到时才会去加载
 *
 * 拓展：
 * 存在反射攻击：class.getDeclaredConstructor → constructor.setAccessible → constructor.newInstance
 * 存在序列化攻击：序列化 → 反序列化
 *
 * @author Wang Mincong
 * @date 2020-07-21 08:58:05
 */
public class LazySingletonInner {

    private LazySingletonInner() {}

    public static LazySingletonInner getInstance() {
        return SingletonHolder.SINGLETON;
    }

    private static class SingletonHolder {
        private static final LazySingletonInner SINGLETON = new LazySingletonInner();
    }

}
