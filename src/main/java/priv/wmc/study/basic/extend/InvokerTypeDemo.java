package priv.wmc.study.basic.extend;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 父类和子类有同名属性，对象调用该属性，变量实际类型是什么就调谁的（和方法重载一样的意思）
 *
 * @author 王敏聪
 * @date 2019-11-04 11:57
 */
@Slf4j
public class InvokerTypeDemo {

    @Test
    public void test() {
//        example();
        example3();
    }

    /**
     * 通过什么类型调用的方法，就是调用实际该类型的方法
     */
    public void example() {
        Child child = new Child("儿子");
        log.info(child.getName());
        log.info(((Parent) child).getName());
    }

    /**
     * 如果下面这个有疑问
     * @see priv.wmc.study.basic.generic.Concept
     */
    public void example1() {
        Parent parent = new Child("仔");
        // 注释的这一行编译报错（泛型不具有多态的特性）
//        Class<Parent> parentClass = Child.class;
//        Class<? extends Parent> parentClass = Child.class;
    }

    /**
     * 通过 List 类型调用 toString 方法，调用的是实际类型的 toString 方法
     */
    public void example2() {
        // java特性，根据实际变量引用类型调用方法（这是ArrayList的复写了toString方法，所以能打印出“[xxx, xxx, ...]”的格式）
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        System.out.println(arrayList);

        // List类型的引用也能像ArrayList打印
        List<String> list = arrayList;
        // List是接口（不含toString实现）,在编译时期进到下面的list.toString()方法
        // 你会发现进到的是Object.toString方法，而实际运行的还是ArrayList.toString方法
        System.out.println(list.toString());
        System.out.println(list);
    }

    /**
     * 父类的静态成员是可以通过子类类名引用访问的，并且访问的是一个值
     */
    public void example3() {
        // 如果只在爹中定义了secret字段，那么通过Child修改了，通过Parent访问也就会得到修改后的值
        // 但是如果都定义了，即各自持有一份，那就遵守 {@link #example} 的原则
        log.info(Parent.secret);
        log.info(Child.secret);

        Child.secret = "儿子的秘密";

        log.info(Parent.secret);
        log.info(Child.secret);

    }

}
