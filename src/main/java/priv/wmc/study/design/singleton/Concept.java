package priv.wmc.study.design.singleton;

import java.util.Arrays;

/**
 * @author Wang Mincong
 * @date 2020-07-21 09:47:00
 */
public final class Concept {

    private Concept() {}

    /**
     * 详见：https://www.cnblogs.com/zsh-blogs/p/10460223.html
     */

    /**
     * 线程安全
     *
     * 如果你的代码所在的进程中有多个线程在同时运行，而这些线程可能会同时运行这段代码
     * 如果每次运行结果和单线程运行的结果是一样的，而且其他的变量的值也和预期的是一样的，就是线程安全的
     *
     * 一个类或者程序所提供的接口对于线程来说是原子操作，或者多个线程之间的切换不会导致该接口的执行结果存在二义性，也就是说我们不用考虑同步的问题，那就是线程安全的
     */

    /**
     * 饿汉式天生就是线程安全的，可以直接用于多线程而不会出现问题，懒汉式本身是非线程安全的
     */

}
