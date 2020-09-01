package priv.wmc.study.jdk8.optional;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

/**
 * 在尚汤的jpa的findById就已经用过了
 * 详情见jdk8的文档，基本用法如下
 *
 * == 返回空的 Optional 实例
 * static <T> Optional<T> empty()
 *
 * == 如果值存在，并且这个值匹配给定的 predicate，返回一个Optional用以描述这个值，否则返回一个空的Optional
 * Optional<T> filter(Predicate<? super <T> predicate)
 *
 * == 如果值存在，返回基于Optional包含的映射方法的值，否则返回一个空的Optional
 * <U> Optional<U> flatMap(Function<? super T,Optional<U>> mapper) 
 *
 * == 如果有值，则对其执行调用映射函数得到返回值。如果返回值不为 null，则创建包含映射返回值的Optional作为map方法返回值，否则返回空Optional
 * <U>Optional<U> map(Function<? super T,? extends U> mapper)
 *
 * == 如果存在该值，返回值， 否则返回 other
 * T orElse(T other)
 *
 * == T orElseGet(Supplier<? extends T> other)
 * 如果存在该值，返回值， 否则返回 other 调用的结果
 *
 * == <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier)
 * 如果存在该值，返回值，否则抛出由 Supplier 继承的异常
 *
 * @author 王敏聪
 * @date 2019-08-24 16:53
 */
@Slf4j
public class OptionalDemo {

    public static void main(String[] args) {
        Integer notNull = new Integer(10);
        Optional<Integer> notNullOptional = Optional.of(notNull);
        // Optional.of(null); 直接报错
        Optional<Integer> nullOptional = Optional.ofNullable(null);
        log.info(String.valueOf(notNullOptional.isPresent()));
        log.info(String.valueOf(notNullOptional.get()));
        log.info(String.valueOf(nullOptional.isPresent()));
        log.info(String.valueOf(nullOptional.get()));
    }

}
