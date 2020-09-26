package priv.wmc.study.basic.generic.enum_test;

import lombok.extern.slf4j.Slf4j;

/**
 * 如何表达一种泛型：实现了特定的接口的枚举类型
 *
 * @author Wang Mincong
 * @date 2020-06-23 13:2:56
 */
@Slf4j
public class EnumGenericConcept {

    private enum Simple {A}

    public static void main(String[] args) {
        demo1(StatusEnum.DISABLE);
        demo2(StatusEnum.DISABLE);
        demo3(StatusEnum.DISABLE);
        extraDemo3(StatusEnum.DISABLE);
        demo4(StatusEnum.DISABLE);

        demo1(Simple.A);
        /// 以下都能够保证类型的正确，即放开注释，编译报错
//        demo2(Simple.A);
//        demo3(Simple.A);
//        extraDemo3(Simple.A);
//        demo4(Simple.A);
    }

    /** 下面是java对一个枚举类型定义的实例 @see ColorEnum */
    // public GenderEnum extends priv.wmc.study.priority.reflect.enums.Enum<GenderEnum> {}

    /** 因此推出如果我们通过使用泛型描述一个枚举类型，应该按照如下的方式定义（推荐） */
    public static <T extends Enum<T>> void demo1(T t) {log.info(t.toString());}

    /** 因此如果描述一个实现指定接口的枚举，应该按照如下的方式定义（推荐） */
    public static <T extends Enum<T> & EnumDefine> void demo2(T t) {t.getValue(); t.getValue();}

    /** 这样写，因为明面上的类型就是枚举，所以使用时需要强转一下，这样弄也行，不会有编译时的警告，就是稍微麻烦一些（不伦不类的） */
    public static <T extends Enum<? extends EnumDefine>> void demo3(T t) {((EnumDefine)t).getValue();}

    /** 直接看肯定蒙，由上面过来过来就清楚了，这就是在泛型上体现上面的强转步骤（最复杂的定义方式） */
    public static <T extends Enum<? extends EnumDefine> & EnumDefine> void demo4(T t) {t.getValue(); t.getValue();}

    /** 不声明额外的泛型类型，只要编译时期要求的类型符合就行（最简单的做法） */
    public static void extraDemo3(Enum<? extends EnumDefine> t) {((EnumDefine)t).getValue();}

    /* 顺序不能反：语法规定 & 符号后边只能跟接口类型，因为java是单继承的，你会说不对啊，不是能够集成普通的类类型么，语法规定类你得写在extends后边
     *
     * 还可以参见{@link CustomJdkTargetProxy#newProxyInstances}
     */
//    public static <T extends EnumDefine & Enum<T>> void demo4() {}

}
