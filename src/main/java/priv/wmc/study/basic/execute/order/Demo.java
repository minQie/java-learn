package priv.wmc.study.basic.execute.order;

/** 
 * 不考虑静态变量的步骤
 * 1、父类 -> 方法区、子类 -> 方法区
 * 2、栈中申请空间，声明引用Person
 * 3、堆内存开辟空间
 * 4、父类、子类针对成员变量的类型进行默认初始化（如int就是0）
 * 5、子类构造方法进栈
 * 6、初始化父类的成员变量
 * 7、父类构造方法进栈 ---执行---> 出栈
 * 8、初始化子类的成员变量
 * 9、将堆内存中的地址赋值给引用变量 ---> 子类构造方法出栈
 * 
 * @author Wang Mincong
 * @date 2020-03-14 14:49
 */
public class Demo {
    
    public static void main(String[] args) {
        new Child();
    }

}
