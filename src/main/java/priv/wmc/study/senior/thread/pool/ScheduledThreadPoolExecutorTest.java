package priv.wmc.study.senior.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * ScheduledThreadPoolExecutor 测试用例
 * 1、ScheduledThreadPoolExecutor 是 ThreadPoolExecutor 的子类
 *
 * @author Wang Mincong
 * @date 2020-03-14 15:39
 */
@Slf4j
public class ScheduledThreadPoolExecutorTest {

    @SneakyThrows
    public static void main(String[] args) {
        // 1、new 一个真正创建线程的工厂
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
            // 是否作为守护线程
            .setDaemon(false)
            .setNameFormat("time-pool-%d")
            .build();

        // 2、new 一个定义定时任务的线程池
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1, threadFactory);

        // --- 此时线程池中进程活跃数: 0, 线程池中线程数量: 0

        // 3、调用线程池提供的用于生产定时任务的方法
        Runnable runnable = () -> log.info("Runnable 定时任务执行了...");
        Callable<String> callable = () -> {log.info("Callable 定时任务执行了..."); return "执行成功!";};
        ScheduledFuture<?> scheduledFuture1 = executor.schedule(runnable, 3, TimeUnit.SECONDS);
        ScheduledFuture<String> scheduledFuture2 = executor.schedule(callable, 3, TimeUnit.SECONDS);

        // 参数 mayInterruptIfRunning true - 如果任务正在运行就中断 false - 如果任务正在运行，则允许执行完毕
        scheduledFuture1.cancel(false);
        // 任务是否被取消了
        scheduledFuture1.isCancelled();

        // --- 此时线程池中进程活跃数: 1, 线程池中线程数量: 1
        // 问题一、为什么线程数是 1，难道不是一个定时任务对应

        // 没有返回值的任务调用，只会拿到 null
        Object result1 = scheduledFuture1.get();
        log.info("Runnable 定时任务执行返回结果: {}", result1);

        // 无论是否有返回值，通过调用 ScheduledFuture.get 方法获取定时任务的返回值，都是阻塞的
        String result2 = scheduledFuture2.get();
        log.info("Callable 定时任务执行返回结果: {}", result2);

        // --- 此时线程池中进程活跃数: 0, 线程池中线程数量: 1

        // 问题二、定时任务明明都执行完了，主线程没有结束的原因？
        // 问题三、线程池大小设置为 1 也能同时执行两个任务么？
        // 答：1 是线程池维护的线程数量，通过查看源码，其实线程池支持的最大线程数为 Integer.MAX

        log.info("线程池中处于工作状态（正在处理定时任务）的线程数: {}", executor.getActiveCount());
        log.info("线程池中线程数量: {}", executor.getPoolSize());

        // 注册一个循环定时任务（每过一定的秒数就执行指定的任务），方法不支持 Callable 的参数
//        executor.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);

        executor.remove(runnable);
        executor.getQueue().remove(runnable);
        executor.getQueue().size();
        executor.shutdown();
        executor.shutdownNow();
    }

}
