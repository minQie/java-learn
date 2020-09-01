package priv.wmc.study.design.singleton;

/**
 * 懒汉式单例实现，不采用原因：效率太低，所有获取对象的进程都要去判断锁
 *
 * @author Wang Mincong
 * @date 2020-07-21 08:58:05
 */
public class SingletonTest1 {

    private static SingletonTest1 singleton;

    private SingletonTest1() {}

    public static synchronized SingletonTest1 getInstance() {
        if (singleton == null) {
            singleton = new SingletonTest1();
        }
        return singleton;
    }

}
