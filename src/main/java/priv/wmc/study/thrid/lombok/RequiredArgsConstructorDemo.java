package priv.wmc.study.thrid.lombok;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 测试@RequiredArgsConstructor
 *
 * 1、生成一个构造方法，方法参数为成员变量中，(非静态 && 未初始化的 && (被final修饰 || @NonNull))的字段
 * 2、如果字段有被“@NonNull”修饰，那么构造方法会为其进行非null检测，如果为null，报错空指针异常
 * ps: @NonNull 只能修饰包装数据类型，否则不起作用
 *
 * @author 王敏聪
 * @date 2019-08-19 15:00
 */
@Getter
@RequiredArgsConstructor
public class RequiredArgsConstructorDemo {

    /** 生成的构造方法不带有这个字段 */
    private Long aLong;

    /** 生成的构造方法不带有这个字段 */
    private final Boolean bool = true;

    /** 生成的构造方法带这个字段 */
    private final String param1;

    /** 生成的构造方法带有这个字段 */
    @NonNull
    private Integer param2;

    /** 生成的构造方法带有这个字段 */
    @NonNull
    private final Integer param3;

    /** 生成的构造方法不带有这个字段 */
    @NonNull
    private Integer integer = 1;

    /** 生成的构造方法不带有这个字段 */
    @NonNull
    private final Integer integer2 = 1;

}
