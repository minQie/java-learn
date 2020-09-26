package priv.wmc.study.senior.juc;

import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import org.junit.Test;

/**
 * <P>Volatile最常说到也是最核心的两点：
 * <P>1.防止JVM对指令的重排序（重排序是计算机底层提高硬件利用率的一种做法）
 * <P>2.保证内容可见性
 *
 * <hr>
 *
 * <p>拓展，重点说明两个内存泄漏问题
 * Thread 存放了 ThreadLocalMap（该类定义在 ThreadLocal 种） 类型的引用，ThreadLocal 中没有
 * ThreadLocalMap 类的定义会告诉你 键是 ThreadLocal<?> 的弱引用类型，值是对应的 ThreadLocal 要存储的值
 *
 * 内存泄漏一：假如 ThreadLocalMap 键的类型不是弱引用，并且实际 jdk 在设计层面上没有开放对 ThreadLocalMap 的操作（也完全没有必要），所以 Thread
 * 没有回收，即线程没有结束的话 → ThreadLocalMap 不会被回收 → 作为键存储的 TheadLocal 不会被回收（内存泄漏）
 *
 * 所以采用弱引用的方式解决了这个问题，但是不按照一定的规则，依然会出现另外一个内容泄漏问题
 *
 * 内存泄漏二：假如 ThreadLocalMap 中的某个 ThreadLocal 被回收了，那么就会出现 null, 值 这样的情况，这个值被 Entry 数组持有着引用，也就是说
 * Thread 中的 ThreadLocalMap 不回收，这个 值 就无法回收，就同上了（内存泄漏）
 *
 * 所以一定要在 ThreadLocal 使用完毕时，主动调用 remove 方法
 *
 * 补充：当使用了线程池，线程结束时，并不会被销毁，这就是真正意义上的内存泄漏了
 *
 * 再拓展：ThreadLocalMap 类似 HashMap 都是基于 hash 算法实现的，ThreadLocalMap 解决 hash 冲突采用的散列算法是开放地址法（HashMap 是链地址法）
 *
 * @author Wang Mincong
 * @date 2020-09-08 21:03:48
 */
public class VolatileTest {

    boolean flag = true;

    void method() {
        System.out.println("start...");
        while (flag) {

        }
        System.out.println("end...");
    }

    /**
     * <P>1.junit的test方法，应有存在导致同步主存的方法，所以，上面的方法可以停止
     * <P>2.使用main方法的方式，上面的方法就不会停
     * <P>3.还有在上面的循环体中添加sop输出，会存在同步主存，故也会停
     */
    @Test
    @SneakyThrows
    public void test() {
        VolatileTest currentClass = new VolatileTest();

        // 方法引用喔
        new Thread(currentClass::method, "testThread").start();

        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);

        // 实际效果就像代码字面含义，线程放弃执行权1秒（推荐使用）
        TimeUnit.SECONDS.sleep(1);
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        currentClass.flag = false;
    }



}
