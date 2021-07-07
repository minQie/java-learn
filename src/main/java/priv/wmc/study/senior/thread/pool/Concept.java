package priv.wmc.study.senior.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * <h1>线程池概念</h1>
 *
 * 池化思想：如线程池、字符串常量池、数据库连接池等，都是用于提供资源利用率的
 *
 * 优点：
 * 1、提高线程的利用率
 * 2、提高程序的响应速度
 * 3、便于统一管理线程对象
 * 4、可以控制最大并发数
 *
 * 缺点：
 * 1、死锁：引入线程池会带来另外一种死锁的可能性，当所有池线程都在等待阻塞队列中一个任务的执行结果，但是该任务因为没有未被占用的线程而无法执行
 * 2、资源不足：线程池如果太大，光是线程之间的切换就有可能耗尽系统所有的资源
 * 3、并发错误：线程池和其他排队机制依赖使用 wait 和 notify 方法，这两个方法难于使用
 * 4、线程泄漏：如果池线程执行任务时抛出 RuntimeException 或者 Error，而池类没有捕获到，那么这线程就可能会因没有支持关闭方法（归还连接池），而被线程池认为不可用
 * 5、请求过载：仅仅时请求就压垮了服务器，这是可能的。排在队列等待执行的任务可能会消耗过多的系统资源引起系统资源匮乏。这时应该定义好相应的策略
 *
 * @author Wang Mincong
 * @date 2020-09-25 07:20:46
 */
public final class Concept {

    private Concept() {
        // j.u.c 包下提供的 Executors 类，提供了以下 5 种线程池的静态创建方法
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        ExecutorService executorService2 = Executors.newCachedThreadPool();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        ScheduledExecutorService scheduledExecutorService1 = Executors.newSingleThreadScheduledExecutor();

        // 重点提一下阿里规范
        // 一、不允许手动创建线程，线程资源必须由线程池提供

        // 二、不允许使用 Executors 去创建线程池，而是通过 ThreadPoolExecutor
        // 通过 Executor 创建的 线程池
        // FixedThreadPool、SingleThreadPool：允许的请求队列长度为Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM
        // CachedThreadPool等线程池：允许的创建线程数量为Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM

        // 目的是为了让写的同学更加明确线程池的运行规则，规避资源耗尽的风险
        // 用自己的话说就是，希望开发人员能够对线程这么一个重量级的资源重视起来，自己对各种配置的参数做到心里有数，其实同 HashMap 规范要求一样的意思
    }

}
