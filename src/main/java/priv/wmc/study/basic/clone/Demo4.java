package priv.wmc.study.basic.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

// 演示实现2
// 1、可序列化的对象要求所有成员都必须是可序列化的
// 2、如果Car和Shape是内部类，因为内部类含有对外部类成员的引用，这样就会要求Demo4实现Serializable接口

@Slf4j
class Demo4 {

    @Test
    public void demo() throws CloneNotSupportedException {
        Car car = new Car("宝马", new Shape("middle", "red"));
        Car clone = serializeClone(car);
        car.setName("保时捷");
        car.getShape().setSize("big");
        car.getShape().setColor("yellow");
        log.info(car.toString());
        log.info(clone.toString());
    }

    public Car serializeClone(Car car) {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        Car clone = null;
        // 不需要真的序列化到硬盘上，只要能完成目的，序列化到内存中也是没毛病的
        try {
            ByteArrayOutputStream bop = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bop);
			// 注意：这个错误找了好久，创建ObjectInputStream一定要放在这句的下面，不然就是EOFException
			oos.writeObject(car);

			ois = new ObjectInputStream(new ByteArrayInputStream(bop.toByteArray()));
			clone = (Car)ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return clone;
	}
}

class Car implements Serializable {
	private static final long serialVersionUID = 4169026457143754175L;
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
	public String toString() {
		return "Car [name=" + name + ", shape=" + shape + "]";
	}

}

class Shape implements Serializable {
	private static final long serialVersionUID = 4557107416608290604L;
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
