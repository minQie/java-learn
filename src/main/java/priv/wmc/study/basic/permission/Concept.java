package priv.wmc.study.basic.permission;

/**
 * <h2>访问控制修饰符</h2>
 *
 * <h3>复习</h3>
 * 1、类（外部类）的修饰符只有默认和public; 但是作为内部类，就相当于外部类的一个成员了，可以被4种修饰符修饰
 * 2、继承层面，关于方法的复写，子类中关于复写方法的权限修饰符，一定是大于等于父类中方法的权限声明的
 *
 * <h3>概念</h3>
 * public    : 对所有类可见。使用对象：类、接口、变量、方法
 * protected : 对同一包内的类和所有子类可见。使用对象：变量、方法。 注意：不能修饰类（外部类）
 * default   : 在同一包内可见。使用对象：类、接口、变量、方法
 * private   : 在同一类内可见。使用对象：变量、方法。 注意：不能修饰类（外部类）
 *
 * <h3>用自己的话概括</h3>
 *  public
 *    无限制
 *  protected
 *   相同包，无限制
 *   不同包下，当前修饰符修饰方法中，子类只能访问重载了的方法
 *
 *     子类与基类在同一包中：被声明为 protected 的变量、方法和构造器能被同一个包中的任何其他类访问
 *     子类与基类不在同一包中：那么在子类中，子类实例可以访问其从基类继承而来的 protected 方法，而不能访问基类实例的 protected 方法
 *       package a class Parent {protect void fun(){...}}
 *       package b class Child extends Parent {public void test(){访问fun方法没问题，访问new Parent().fun()就不行}}
 *  default
 *    相同包下：无限制
 *  private
 *    只有当前类中内访问
 *
 * <h3>protect实例1</h3>
 * java.util.concurrent.ConcurrentHashMap 可以直接访问 java.util.Map（接口）.Entry（接口）
 * 因为 Entry 在接口中定义，即默认带上public修饰
 * （接口在类中定义，内部包中的类就无法访问了，接口在类中定义还添加了public修饰就可以了）
 * （给内部接口添加public修饰服：Modifier 'public' is redundant for inner interfaces）
 *
 * <h3>protect实例2</h3>
 * class Object {protected native Object clone();}
 *
 * a.A {}
 * B extends A {}
 *
 * 问：能够在A中调用 new B().clone() 么
 * 解答：能，clone 方法要看做定义在A中的方法，clone 方法有protect修饰，那么clone就只能在a报下的类（上例符合这条规则），或者别的包的A的子类中调用
 *
 * 疑惑点：clone方法不是Object的么？
 * 解惑：请你好好想一想，如果真的按照clone方法是Object的方法，那clone方法不就只能在子类中调用了么，这个限制太大了
 * 统计包性质相当于没了，因为只能在Object的同级包下，调用clone方法了
 * 但是这个方法传递规律又不具有普及性，拿上例来说，如果B继承自A，即clone方法算定义在B中，这与实际不符，因为你不能在B的同级目录下的C调用new B().clone()
 *
 * <h3>更多protect示例 https://www.runoob.com/w3cnote/java-protected-keyword-detailed-explanation.html</h3>
 *
 * <h3>迷惑点</h3>
 * 1、权限具体是针对什么的权限：无论方法怎么定义，方法肯定定义在某个类中，那么就只能通过该类调用，权限就是通过这个类能够在哪里调用的权限
 *
 * @author Wang Mincong
 * @date 2020-08-03 08:29:59
 */
public final class Concept {

    private Concept() {}

}
