package priv.wmc.study.design.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉式单例实现：经典
 *
 * @author Wang Mincong
 * @date 2020-07-21 08:58:05
 */
@Slf4j
public class EagerSingleton {

    private static final EagerSingleton SINGLETON = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return SINGLETON;
    }

}
