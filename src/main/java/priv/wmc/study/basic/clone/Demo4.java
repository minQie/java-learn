package priv.wmc.study.basic.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 1、可序列化的对象要求所有成员都必须是可序列化的
 * 2、如果Car和Shape是内部类，因为内部类含有对外部类成员的引用，这样就会要求Demo4实现Serializable接口
 *
 * @author Wang Mincong
 * @date 2020-09-04 16:09:30
 */
@Slf4j
public class Demo4 {

    @Test
    public void demo() {
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

@Getter
@Setter
@ToString
@AllArgsConstructor
class Car implements Serializable {
    private static final long serialVersionUID = 4169026457143754175L;

    private String name;
    private Shape shape;
}

@Getter
@Setter
@ToString
@AllArgsConstructor
class Shape implements Serializable {
    private static final long serialVersionUID = 4557107416608290604L;

    private String size;
    private String color;
}
