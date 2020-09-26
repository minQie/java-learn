package priv.wmc.study.basic.string;

/** 
 * --介绍<br>
 * 底层是Char[]<br>
 * <br>
 * --常量池介绍<br>
 * 字符串常量池专门用来存储字符串常量，可以提高内存的使用率，避免重复开辟内存空间存储相同的字符串<br>
 * 当创建字符串常量时，JVM会首先检查字符串常量池<br>
 * 如果字符串已经存在池中，就返回池中实例引用，如果字符串不再池中，就会实例化一个字符串放到池中，并返回引用<br>
 * <br>
 * --不可变性<br>
 * 这个和String类被final修饰没有关系，不可变性是指一个String对象是无法修改的<br>
 * （什么鬼，不能修改？String a = "123"; a = a + "4";没报错啊。没错不会报错，但是你会发现修改后，对象a在内存中的地址改变了，那已经是一个新的对象了）<br>
 * <br>
 * --intern方法<br>
 * 强制返回常量池中存在的相同字符串内容的对象地址<br>
 * <br>
 * @author Wang Mincong
 * @date 2020-05-06 22:34
 */
public class BasicConcept {

    String a = new String();

}
