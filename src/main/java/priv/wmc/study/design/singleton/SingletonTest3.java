package priv.wmc.study.design.singleton;

/**
 * 懒汉式单例实现：静态内部类
 *
 * 核心：利用了classloader的机制来保证初始化instance时只有一个线程，并且只有加载好了（发生重排序也得都执行好了），才能提供给其他线程使用
 *
 * 疑点：这个为什么是懒汉式，不是说类加载么？（在私有构造里边加上一条日志，就可以验证是否时懒汉式了）
 * 明确：静态内部类的加载机制（×）JVM类加载机制（√）：静态 != 程序一运行就去加载，实际还是使用到时才回去加载
 *
 * 其实静态内部类与普通类除了在访问时需要使用外部类做入口外，其他地方与普通类没有任何区别，因此只要不加载静态内部类，其静态常量就不会被初始化
 *
 * @author Wang Mincong
 * @date 2020-07-21 08:58:05
 */
public class SingletonTest3 {

    private SingletonTest3() {}

    public static SingletonTest3 getInstance() {
        return SingletonHolder.singleton;
    }

    private static class SingletonHolder {
        private static SingletonTest3 singleton = new SingletonTest3();
    }

}
