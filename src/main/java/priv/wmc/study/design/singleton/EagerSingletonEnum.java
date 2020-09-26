package priv.wmc.study.design.singleton;

/**
 * effective java一书中有提到
 *
 * @author Wang Mincong
 * @date 2020-07-21 10:09:22
 */
public enum EagerSingletonEnum {

    INSTANCE;

    public void func() {
        // 我是单例对象提供的一个非静态方法
    }

}
