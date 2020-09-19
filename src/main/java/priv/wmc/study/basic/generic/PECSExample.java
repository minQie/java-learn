package priv.wmc.study.basic.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * PECS（Producer Extends, Consumer Super）
 *
 * 阿里java规范：【强制】泛型通配符<? extends T>来接收返回的数据，此写法的泛型集合不能使用add方法，而<? super T>不能使用get方法，两者在接口调用赋值的场景中容易出错。
 * 说明：扩展说一下PECS(Producer Extends Consumer Super)原则：
 * 第一、频繁往外读取内容的，适合用<? extends T>。
 * 第二、经常往里插入的，适合用<? super T>
 *
 * 误区：不能存，那里面的数据是从哪来的？不能取，那存里边的数据有什么用？
 * 答1：你用上PECS的类型定义才有这些规则，可是通过别的类型依旧可以操作在堆内容的对象啊
 * 答2：并不是所有的业务场景都需要取的，比如 java.util.Comparator，作为消费者能够消费两个对象，并给出两个对象的顺序
 * 例如：List<? extends Child> children = Arrays.asList(new Child(), new Child(), new Child());
 *
 * 核心：Producer 和 Consumer
 * 希望做一个限定，比如说某个集合在准备好数据后，并且确定在接下来的场景中不会再往里边添加数据了，只用于读，那就应该使用这样的泛型修饰<? extends Xxx>
 *
 * @author Wang Mincong
 * @date 2020-09-03 10:37:37
 */
public class PECSExample {

    private static class Parent{}

    private static class Child extends Parent {}

    public void test() {
        // 一定要区分开 存和取 进行理解，不然你对 extends和super 只有从取的角度，是无法理解的

        // 编译器只知道集合中元素的类型是Parent的子类（不包括Parent???），具体是什么子类不清楚
        // 存：故无法添加确切的子类类型到集合中，父类居然是不可以存的???
        // 取：能够定义一个确切的父类类型去接收
        // 所以他只用于作为 Producer（白话就是数据提供者，只用于遍历、获取，所以只读不写时）
        List<? extends Parent> list1 = new ArrayList<>();
//        list1.add(new Object());
//        list1.add(new Parent());
//        list1.add(new Child());

        Parent parent = list1.get(0);

        // 编译器只知道集合中元素的类型是Child的父类（包括Child），具体是什么父类不清楚
        // 存：无法添加确切的父类类型到集合中，但是子类是可以存的
        // 取：无法定义一个更加确切的父类类型去接收（但是java类型是有上限的，故可以用Object接收）
        // 所以他只用于作为 Consumer（白话就是数据获取者，所以只写不可读时，使用该类型）
        List<? super Child> list2 = new ArrayList<>();
//        list2.add(new Object());
//        list2.add(new Parent());
        list2.add(new Child());

        Object object = list2.get(0);
    }

}
