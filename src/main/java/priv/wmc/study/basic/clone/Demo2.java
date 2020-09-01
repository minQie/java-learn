package priv.wmc.study.basic.clone;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 演示浅克隆
 * 浅克隆：只复制基本类型的数据，引用类型的数据只复制了引用的地址，引用的对象并没有复制，在新的对象中修改引用类型的数据会影响原对象中的引用
 */
@Slf4j
public class Demo2 {

    @Test
    public void demo() throws CloneNotSupportedException {
        Car car = new Car("宝马", new Shape("middle", "red"));
        Car clone = car.clone();
        car.setName("保时捷");
        // 错误浅克隆示范，因为这样做体现不出浅克隆
        //car1.setShape(new Shape("big","yellow"));
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

        @Override
        public Car clone() throws CloneNotSupportedException {
            return (Car) super.clone();
        }

        @Override
        public String toString() {
            return "Car [name=" + name + ", shape=" + shape + "]";
        }

    }

    class Shape {
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
        public String toString() {
            return "Shape [size=" + size + ", color=" + color + "]";
        }

    }
}
