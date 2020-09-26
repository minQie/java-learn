package priv.wmc.study.jdk8.interface_default_method;

/** 
 * 新增接口的默认方法：接口可以有实现方法
 * 
 * 为了解决接口的修改与现有的实现不兼容的问题。
 * 
 * @author Wang Mincong
 * @date 2019-08-24 16:20
 */
public class DefaultMethodDemo {
    
    public static void main(String[] args) {
        new HowMuch().howMuch();
    }
}
