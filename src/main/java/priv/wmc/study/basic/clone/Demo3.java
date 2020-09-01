package priv.wmc.study.basic.clone;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

// 一、深克隆：在引用类型的类中也实现了clone，是clone的嵌套，复制后的对象与原对象之间不会互相影响
// 二、已经实现深克隆的类：八大基本数据类型，以及对应的包装类型；还有String
/* 1、String为什么能实现深克隆
 * 因为String被final修饰，被 Sun公司的工程师写成了一个不可更改的类（immutable class）
 * 在所有String类中的函数都不能更改自身的值（注：和final关键字无关？测试一下final class）
 * 给String重新赋值，本质上是new String()，故原String对象并没有改变，依旧在堆内存
 * 所以不会影响克隆的String，克隆的String依旧指向原String对象
 *
 * 因为基本数据类型对应的Integer、Double等都是不可更改类，故深克隆原理同String
 *
 * 2、不是所有的类都能实现深度clone的
 * 例如，StringBuffer类型，看一下 JDK API中关于StringBuffer的说明，StringBuffer没有重载clone()方法，更为严重的是StringBuffer还是一个 final类
 * 这也就是说我们也不能用继承的办法间接实现StringBuffer的clone，如果一个类中包含有 StringBuffer类型的成员变量或者和 StringBuffer相似的对象
 * 所以有两种选择：要么只能实现影子clone（浅克隆），要么在clone方法中new StringBuffer()克隆
 *
 * 实现1：所有类都继承Cloneable接口并实现clone方法，并在clone方法中为属性调用clone方法
 * 实现2：序列化和反序列化
 *
 * 假实现：类比修改set方法，在set中为引用对象新建一个对象/值（可行？）
 */

/**
 * 演示实现1
 * @author Wang Mincong
 */
@Slf4j
public class Demo3 {

    @Test
    public void demo() throws CloneNotSupportedException {
        Car car = new Car("宝马", new Shape("middle", "red"));
        Car clone = car.clone();
        car.setName("保时捷");
        car.getShape().setSize("big");
        car.getShape().setColor("yellow");
        log.info(car.toString());
        log.info(clone.toString());
    }

    class Car implements Cloneable {
        private String name;
        private Shape shape;

        public Car(String name, Shape shape) {
            this.name = name;
            this.shape = shape;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Shape getShape() {
            return shape;
        }

        public void setShape(Shape shape) {
            this.shape = shape;
        }

        // 当然硬着头皮在这里实现深克隆也能实现效果，但是绝对不推荐
        @Override
        public Car clone() throws CloneNotSupportedException {
            Car car = (Car) super.clone();
            car.shape = car.shape.clone();
            return car;
        }

        @Override
        public String toString() {
            return "Car [name=" + name + ", shape=" + shape + "]";
        }

    }

    class Shape implements Cloneable {
        private String size;
        private String color;

        public Shape(String size, String color) {
            this.size = size;
            this.color = color;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public Shape clone() throws CloneNotSupportedException {
            return (Shape) super.clone();
        }

        @Override
        public String toString() {
            return "Shape [size=" + size + ", color=" + color + "]";
        }

    }
}
