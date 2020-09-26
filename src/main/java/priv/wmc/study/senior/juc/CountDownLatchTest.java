package priv.wmc.study.senior.juc;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-09-08 19:35:37
 */
@Slf4j
public class CountDownLatchTest {

    private static volatile Integer a = 0;

    @Test
    @SneakyThrows
    public void test() {
        Thread[] threadArray = new Thread[10];
        CountDownLatch countDownLatch = new CountDownLatch(threadArray.length);

        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    a++;
                }
                countDownLatch.countDown();
            });
        }

        Arrays.stream(threadArray).forEach(Thread::start);

        countDownLatch.await();

        // 一、按照程序逻辑来说，a最终的值应该为1000 * 10 = 10000，可实际不是，很明显
        // 1、a++ 不是原子操作
        // 2、这是一个多线程问题，需要加锁来解决，要锁住的操作是 a++

        // 二、解决办法：
        // 1、a++ 用synchronized围起来
        // 2、将变量a的类型改为 AtomicInteger，通过里面的原子操作的自增方法来解决（juc包下的实现都是 cas CompareAndSwap）

        // 三、volatile的误区
        // 原子性、可见性、有序性，使用防止指令重排和保证可见性的 volatile 并不能解决这个问题，因为解决这个问题急需要保证可见性，还要保证原子性，很明显，volatile只能保证前者
        // 当只有一个线程可以修改字段的值，其它线程可以随时读取，那么把字段声明为volatile是合理的

        // 四、深究
        // cas的aba问题：加一个版本号解决
        // cas的原子操作如何保证：最底层是一条汇编指令 lock cmpxchg 指令 - 锁总线
        log.info(String.valueOf(a));

        TimeUnit.SECONDS.sleep(1);
    }

}
