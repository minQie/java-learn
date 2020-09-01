package priv.wmc.study.basic;

/**
 * interface实际上就是一个抽象的，再加上abstract修饰没有多大含义，唯一可能看到这种情况就是用反编译工具生成的代码
 *
 * jdk源码中通常都标明了abstract和interface同时修饰一个接口
 *
 * 注意别和“抽象接口”的概念混淆了，所谓“抽象接口”，即在提供接口的同时，提供一个抽象类，用抽象类实现该接口(实际上这是缺省适配模式)
 *
 * http://www.cnblogs.com/iyangyuan/archive/2013/03/11/2954808.html
 *
 * @author Wang Mincong
 * @date 2020-07-21 21:15:41
 */
public abstract interface AbstractInterface {
}
