package priv.wmc.study.jdk8.interface_default_method;

/** 
 * @author 王敏聪
 * @date 2019-08-24 16:21
 */
public interface Two {

    default void howMuch() {
        System.out.println(2);
    }

}
