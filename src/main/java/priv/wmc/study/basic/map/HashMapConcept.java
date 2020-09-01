package priv.wmc.study.basic.map;

import java.util.HashMap;

/**
 * HashMap类主要用来处理具有键值对特征的数据，随着JDK版本的更新，JDK1.8对HashMap底层也进行了优化
 *
 * HashMap extends AbstractMap implements Map
 *
 * HashMap是基于哈希表对Map接口的实现，hashMap具有较快的访问速度，但是遍历顺序确实不确定的
 *
 * ConcurrentHashMap、HashTable、TreeMap、HashMap的键值是否可以为空，忘记了就看源码，或者查《阿里规范》
 *
 * HashMap并非线程安全，当存在多个线程同时写入HashMap时，可能会导致数据不一致
 *
 * @author 王敏聪
 * @date 2020-05-06 21:01
 */
public final class HashMapConcept {

    private HashMapConcept() {}

    /*关键属性说明
     *
     * -- 容量
     * 空参构造并不会立即为数组申请空间，而是在第一次调用put方法时，调用resize方法对内部类Node<String, String>数组进行初始化
     * 默认的数组大小：static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
     *
     * -- 负载因子
     * final float loadFactor;
     * 默认的负载因子：static final float DEFAULT_LOAD_FACTOR = 0.75f
     *
     * -- 实际容器数组（哈希桶）
     * Node：hash、key、value、next
     * transient Node<K,V>[] table;
     *
     * -- 所能容纳键值对的临界值 = 数组长度 * 负载因子
     * int threshold;
     *
     * -- 结构发生变化的次数
     * transient int modCount;
     *
     * -- entrySet() 方法返回值的一个缓存
     * transient Set<Map.Entry<K,V>> entrySet
     *
     * --HashMap是数组 + 链表 + 红黑树的存储结构
     * static final int TREEIFY_THRESHOLD = 8
     * static final int UNTREEIFY_THRESHOLD = 6
     * 链表 ---长度等于8时---> 红黑数 ---长度等于6时---> 链表
     *
     * --当HashMap的哈希桶长度大于64时，哈希桶也会转为红黑树结构
     * static final int MIN_TREEIFY_CAPACITY = 64
     *
     * -- 插入数据
     * 1、将键hashCode的右移16位得到的高16位和低16位进行异或运算
     * 2、将上面的结果 和 哈希桶长度 - 1 进行与 -> 获得保留位，以计算下标
     *
     * 插入数据超过临界值时，将新建一个桶数组容量为原来的两倍，并重新赋赋值（JDK1.7和JDK1.8赋值的方式有不同：头插法、尾插法）
     */
    private final HashMap hashMap = new HashMap<String, String>();

}
