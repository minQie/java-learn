package priv.wmc.study.design.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉式单例实现：经典
 *
 * @author Wang Mincong
 * @date 2020-07-21 08:58:05
 */
@Slf4j
public class SingletonTest4 {

    private static SingletonTest4 singleton = new SingletonTest4();

    private SingletonTest4() {
        log.info("123123123");
    }

    public static SingletonTest4 getInstance() {
        return singleton;
    }

}
