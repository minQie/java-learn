package priv.wmc.study.basic.extend;

import lombok.Getter;

/**
 * <h2>构造方法</h2>
 * 
 * <p>如果父类无有参构造函数，则子类继承父类就不会要求强制性的要求调用父类的构造函数，编译器会默认帮你调用父类的无参构造函数
 * <p>子类构造函数通过super调用父类的构造函数，语法规定要放在第一行
 * 
 * @author Wang Mincong
 * @date 2019-08-27 12:39
 */
@Getter
public class Child extends Parent {

    public static String secret = "儿的秘密";

    private final String name;
    
    Child(String name) {
        super("爹");
        this.name = name;
    }

}
