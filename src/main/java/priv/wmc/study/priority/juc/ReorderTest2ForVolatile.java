package priv.wmc.study.priority.juc;

import org.junit.Test;

/**
 * 样例2，实际上就是单例模式 - 懒汉式的经典的双重检验锁 DCL（Double Check Lock）实现 中 单例对象是否要添加 volatile 关键字修饰
 *
 * 实际案例就不 敲了，可以重去看 {@link priv.wmc.study.design.singleton} 包下的案例
 *
 * 这里重点是为了说清楚 volatile ，主要为了说明一个比如 new Object() 这样简单的语句，在汇编层面是怎么样的
 * 1、安装 jclasslib Bytecode viewer  插件
 * 2、使用插件：View Show → Show Bytecode With Jclasslib → Methods → 你的方法 → Code → 核心的三句如下：
 *
 * new #2 <java/lang/Object> 在堆内存中创建对象
 * dup 进行属性的默认值初始化
 * invokespecial #1 <java/lang/Object.<init>> 进行属性的初始化
 *
 * @author Wang Mincong
 * @date 2020-09-09 19:53:11
 */
public class ReorderTest2ForVolatile {

    @Test
    public void test() {
        Object obj = new Object();
    }

}
