package priv.wmc.study.priority.juc;

import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import org.junit.Test;

/**
 * <P>Volatile最常说到也是最核心的两点：
 * <P>1.防止JVM对指令的重排序（重排序是计算机底层提高硬件利用率的一种做法）
 * <P>2.保证内容可见性
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
