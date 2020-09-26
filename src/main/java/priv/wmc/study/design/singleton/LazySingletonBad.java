package priv.wmc.study.design.singleton;

/**
 * 懒汉式单例实现，不采用原因：效率太低，所有获取对象的进程都要去判断锁
 *
 * @author Wang Mincong
 * @date 2020-07-21 08:58:05
 */
public class LazySingletonBad {

    private static volatile LazySingletonBad singleton;

    private LazySingletonBad() {}

    public static synchronized LazySingletonBad getInstance() {
        if (singleton == null) {
            singleton = new LazySingletonBad();
        }
        return singleton;
    }

}
