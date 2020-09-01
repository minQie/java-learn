package priv.wmc.study.design.singleton;

/**
 * 懒汉式单例实现：经典懒汉式
 *
 * 但其实隐含的问题：
 * 创建对象的3个步骤
 * 1. 分配内存空间
 * 2. 初始化对象
 * 3. 将内存空间的地址赋值给对象的引用
 * 本该是按照上面顺序执行的步骤，jvm要是对代码进行了重编排，那顺序就不是这样了，如果2和3颠倒，那就肯定有问题了
 *
 * 解决：禁止重排序行为 - volatile
 *
 * @author Wang Mincong
 * @date 2020-07-21 08:58:05
 */
public class SingletonTest2 {

    private static volatile SingletonTest2 singleton;

    private SingletonTest2() {}

    public static SingletonTest2 getInstance() {
        if (singleton == null) {
            synchronized (SingletonTest2.class) {
                if (singleton == null) {
                    singleton = new SingletonTest2();
                }
            }
        }

        return singleton;
    }

}
