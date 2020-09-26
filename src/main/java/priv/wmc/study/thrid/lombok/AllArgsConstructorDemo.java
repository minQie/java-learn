package priv.wmc.study.thrid.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** 
 * 测试 @AllArgsConstructor
 * 
 * 1、生成的构造函数，参数包括所有“非静态、未被初始化的成员变量”
 * 
 * All、对@NoArgsConstructor、@RequiredArgsConstructor、@AllArgsConstructor三个注解都生效的属性：staticName = "xxx"
 *     指定这个属性后，三个注解生成的构造方法会被private修饰
 *     并停供一个定义为：“public static 类名 xxx(参数同构造方法参数)”的方法来获取对象实例
 * 
 * All、同样对三个注解都生效的属性：onConstructor_ = 注解
 *     官网：这个属性是为了能够将注解添加到生成的构造方法上，目前只是一个实验性的特性
 * 
 * All、官网：显示声明和由这三种注解生成的构造方法同定义的构造方法，并不会停止这些注解生成构造方法，所以会报错
 * 
 * @author Wang Mincong
 * @date 2019-08-19 15:00
 */
@Getter
@AllArgsConstructor(staticName = "of")
public class AllArgsConstructorDemo {

    private String s1;
    private final String s2 = "1";

}
