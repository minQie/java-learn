package priv.wmc.study.jdk8.method_quato;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import priv.wmc.study.basic.generic.pojo.Father;

/**
 * 方法引用
 *
 * @author 王敏聪
 * @date 2019-08-24 16:49
 */
@Slf4j
public class MethodQuotaTest {

    private static final List<Father> LIST =  Arrays.asList(new Father("小明"), new Father("大明"));

    public static void main(String[] args) {
//        new MethodQuotaDemo().demo();
        String a = "a";
        assignment(a);
        log.info(a);
    }

    public static void assignment(String a) {
        a = "s";
    }

    /**
     * 方法引用中的this（在本例中，this指代引用方法的参数）
     */
    public void demo() {
        Function<String, String> f1 = (s) -> this.detail(s);
        Function<String, String> f2 = this::detail;
        log.info(f1.apply(1 + ""));
        log.info(f2.apply(2 + ""));
    }
    public String detail(String detail) {
        return detail;
    }

    /**
     * 方法引用Demo
     */
    public void functionQuoteDemo() {
        // 1、构造器引用 - Class::new（只能调用目标对象无参构造方法）
        Supplier<Father> userSupplier = Father::new;
        Father defaultUser = userSupplier.get();
        log.info(defaultUser.toString());

        // 2、静态方法引用 - Class::static_method（只能是有参的）
//        list.forEach(User :: whoScream);
        LIST.forEach(Father:: screamByUser);

        // 3、动态方法引用 - Class::method(只能是无参的)
        LIST.forEach(Father:: scream);
//        list.forEach(User :: substitudeSream);

        // 4、特定对象的方法引用
        Father xiaohong = new Father("小红");
        LIST.forEach(xiaohong::substitudeScream);

        // 相当于“user”作为参数，传入“xiaohong.substitudeSream(user)”
        Consumer<Father> consumer = xiaohong::substitudeScream;
        log.info(consumer.toString());
    }

    /**
     * 方法引用 - ::
     * 方法引用通过方法的名字来指向一个方法，构造更紧凑简洁，减少冗余代码
     */
    public List<String> superior() {
        // Function、Converter都行
//        Function<User, String> function1 = (user -> user.getUsername());
        Function<Father, String> function = (Father:: getUsername);
        Converter<Father, String> converter = Father::getUsername;

        return LIST.stream().map(function).collect(Collectors.toList());
    }
}
