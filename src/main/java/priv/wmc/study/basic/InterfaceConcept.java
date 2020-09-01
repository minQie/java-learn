package priv.wmc.study.basic;

/**
 * 接口中的成员都有固定的修饰符，不写也会默认给你加上：
 *  变量：public static final 数据类型（全局 静态 常量）
 *  方法：public abstract
 *
 * 实现一个接口，要复写里面的所有方法，否者实现接口的类就是一个抽象类
 *
 * 接口之间可以继承，可以多继承，但继承的多个接口中的方法必须是不同名的
 *
 * @author Wang Mincong
 * @date 2020-07-21 21:17:58
 */
public final class InterfaceConcept {

    private InterfaceConcept() {}

}
