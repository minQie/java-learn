package priv.wmc.study.senior.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * ThreadPoolExecutor 测试用例
 *
 * 简单描述一下工作原理：
 * ThreadPoolExecutor 类比柜台
 * Thread 即线程，类比柜台工作人员
 * poolSize 相关参数类比柜台的工作人员的数量
 * keepAliveTime 类比如果柜台工作人员发现等待了一定时间也没有任务（线程会被关闭）
 * Runnable 或者 Callable 类比客户
 * workQueue：类比柜台前边的座位
 *
 * 比如这时来了一个新任务，而现有柜台工作人员都处于忙碌状态，且座位已满，且柜台的工作人员未达到最大人数，这时会新增一个柜台工作人员
 * 假如柜台工作人员也已达最大值，最后一个 handler 参数就是用于指定这时的应对策略
 *
 * @author Wang Mincong
 * @date 2020-09-23 22:48:10
 */
public class ThreadPoolExecutorTest {

    @Test
    public void test() {
        /*
        corePoolSize：线程池常驻线程数
        maximumPoolSize：线程池中允许的最大线程数
        keepAliveTime：线程池中空闲将被释放的时间
        unit： ↑ 参数的时间单位
        workQueue：排队的队列
        threadFactory：线程创建工厂
        handler：当队列也排满了的新定时任务的处理策略
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            3,
            5,
            0L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(3),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 9; i++) {
            executor.execute(() -> System.out.println(Thread.currentThread().getName() + " --- 处理任务"));
        }
    }

}
