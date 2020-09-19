package priv.wmc.study.priority.juc;

import lombok.SneakyThrows;

/**
 * @author Wang Mincong
 * @date 2020-09-09 19:53:11
 */
public class ReorderTestForVolatile {

    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    @SneakyThrows
    public static void main(String[] args) {
        int i = 0;

        for (;;) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            // 一、指令重排 体现在下面两个线程中的两句指令的顺序在执行过程中是否会发生变化
            // 运用的是是反证法：假设没有指令重排，那么两个线程中执行的第一条语句，要不是 a = 1，要不是 b = 1，而只要执行了任意一句，
            // 接下来的 x 和 y 的赋值，都会保证 x y 中至少有一个为1

            // 实际测试的现象是：会出现 x = 0, y = 0 的情况，故反证

            // 二、说到cpu的指令 As-if-serial（看上去就好像是序列化执行的），指的就是cpu的乱序执行。即，不管如何重排序，单线程执行结果不变

            // 三、说到指令重排序，那肯会牵扯到 Happens-before 原则，这个原则就是表述在什么情况下不会进行指令重排序，除此之外都会进行指令重排序

            // 四、volatile 是怎么做到防止指令重排序的呢？JVM定义了一个规范，由硬件、操作系统、HotSpot（JVM级别） 来实现都行
            // JVM级别是通过 JSR 内存屏障来实现的：LoadLoad LoadStore StoreLoad StoreStore
            Thread one = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread two = new Thread(() -> {
                b = 1;
                y = a;
            });

            one.start();
            two.start();
            // join 执行到threadXxx.join方法的线程，会等待threadXxx执行完后，再接着走接下来的语句
            // 下面写法的意思就是，保证两个线程都执行完，再执行下面的sop
            one.join();
            two.join();

            System.out.println("第" + i + "次：x = " + x + ", y = " + y);
            if (x == 0 && y == 0) {
                System.out.println("proved...");
            }
        }
    }

}
