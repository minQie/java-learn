package priv.wmc.study.priority.concurrent;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-08-01 17:14:53
 */
public class BasicTest {

    @Test
    public void test() throws Exception {
        demo();
    }

    private void demo() throws ExecutionException, InterruptedException {
        // 线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，
        // 这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险
        // 说明：Executors返回的线程池对象的弊端如下
        // FixedThreadPool SingleThreadPool CachedThreadPool 允许的请求队列长度为Integer.MAX_VALUE，可能会堆积大量的请求，从而导致OOM
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();

        // org.apache.commons.lang3.concurrent.BasicThreadFactory
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(
            1,
            new BasicThreadFactory.Builder()
                .namingPattern("example-schedule-pool-%d")
                .daemon(true)
                .build()
        );

//        // Common Thread Pool
//        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
//            .setNameFormat("demo-pool-%d")
//            .build();
//
//        ExecutorService executorService2 = new ThreadPoolExecutor(
//            5,
//            200,
//            0L,
//            TimeUnit.MILLISECONDS,
//            new LinkedBlockingQueue<>(1024),
//            namedThreadFactory,
//            new ThreadPoolExecutor.AbortPolicy());
//
//        executorService2.execute(()-> System.out.println(Thread.currentThread().getName()));
//        // gracefully shutdown
//        executorService2.shutdown();

        Map<String, String> map = Collections.singletonMap("a", "a");
        Future<?> future = executorService.submit(() -> map.get("a"));

        // 阻塞方法
        Object o = future.get();
        System.out.println(o);

        // 视频说只有执行了下面这句，a 一定会被打印
        executorService.shutdown();
    }

}
