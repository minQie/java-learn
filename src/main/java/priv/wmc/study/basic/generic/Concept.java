package priv.wmc.study.basic.generic;

/**
 * 一、泛型概念
 * 例：Child extends Father extends GrandFather
 * 实际传参 形参定义
 * <Child>               满足     <? extends Child>、<? super Child>             体现出=的意思
 * <? extends Child>     满足     <? extends Father>、<? extends GrandFather>    体现出<=的意思
 * <? super GrandFather> 满足     <? super Father>、<? super Child>              体现出>=的意思
 *
 * List<*>                  满足     List<Object>、List<?>、List<? extends Object>
 *
 * 泛型没有多态：List<People> = new ArrayList<User>()（×）
 * 泛型不能使用基本类型：List<int>（×）
 * 类上定义的泛型，静态不能使用：
 *     class User<T> { static T method(T t) }（×）
 *     class User<T> { static User<T> method(T t) }（×）
 *     class User<T> { static <T> T method(T t) }（√）
 * 无论是类上定义还是方法上定义的泛型，无论是静态还是动态，都不能用来创建数组 - Cannot date a generic array of Main<User>（声明是可以的）
 * 形参需要指定泛型，传参没有指定：List<Integer> list = new ArrayList(); - 编译有警告，实际用的Object
 *
 * 二、 泛型嵌套
 * A<B<T>>
 *
 * 三、泛型擦除（擦除后按Object处理、依然存在警告（传Object可以去除，有些画蛇添足））
 * 父类：class B<T1, T2>
 *
 * 子类 - 保留父类：A<T1, T2> extends B<Integer, String>
 * 子类 - 部分保留：A<T1, T2> extends B<Integer, T1>
 * 子类 - 不保留：  A<T1, T2> extends B<T1, T2>
 * 子类 - 不保留：  A<T1, T2> extends B（不指定类型，擦除，详见当前类的内部类（用接口也一样）A和B）
 *
 * @author 王敏聪
 * @date 2019-08-09 13:41
 */
public final class Concept {

    private Concept() {}

}
