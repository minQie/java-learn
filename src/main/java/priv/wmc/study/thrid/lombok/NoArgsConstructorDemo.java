package priv.wmc.study.thrid.lombok;

import lombok.Getter;
import lombok.NoArgsConstructor;

/** 
 * 测试@NoArgsConstructor
 * 
 * 1、会生成无参构造方法（因为一个类不指定构造方法，会自动生成一个无参构造方法，所以这个注解是搭配其他注解使用的）
 * 2、如果成员变量中有final修饰的变量，通过设置force参数，可以实现强行赋值为“0 / false / null”的效果
 * 
 * @author Wang Mincong
 * @date 2019-08-19 15:00
 */
@Getter
@NoArgsConstructor(force = true)
public class NoArgsConstructorDemo {

    private final String string;

    private final boolean bool;

    private final int integer;
}
