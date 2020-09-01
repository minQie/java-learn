package priv.wmc.study.priority.thread;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 王敏聪
 * @date 2020-03-14 15:39
 */
@Slf4j
public class ScheduledThreadPoolExecutorDemo {

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setDaemon(false).setNameFormat("time-pool-%d").build();
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1, threadFactory);

        Runnable task = () -> {
            log.info("5秒后");
        };
        ScheduledFuture<?> schedule = executor.schedule(task, 5, TimeUnit.SECONDS);

//        log.info("取消定时任务，结果：" + schedule.cancel(false));
//        log.info("是否已取消" + schedule.isCancelled());

        executor.scheduleAtFixedRate(() -> {executor.getActiveCount(); log.info(String.valueOf(executor.getPoolSize()));}, 1, 1, TimeUnit.SECONDS);


        // 这个居然没用
//        executor.remove(task);
//        executor.getQueue().remove(task);
        // 这个也没用：返回false
//        log.info("移除后，定时任务数量: " + executor.getQueue().size());

        // 如果定时任务都结束了，结束当前定时池 - 否则依然有线程在运行
//        executor.shutdown();

        // 立即中止所有定时任务
//        executor.shutdownNow();
    }

}
