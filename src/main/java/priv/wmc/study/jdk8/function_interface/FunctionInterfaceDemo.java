package priv.wmc.study.jdk8.function_interface;

import java.util.function.Consumer;

/**
 * 测试JDK8的函数接口
 *
 * 1、Consumer<T> - 接收T对象，无返回值
 *       BiConsumer<T, U> - 接收T和U对象，无返回值
 *         DoubleConsumer - 接收Double，无返回值
 *         IntConsumer - 接收Integer，无返回值
 *         ObjDoubleConsumer<T> - 接收T和Double，无返回值
 *         ObjIntConsumer<T> - 接收T和Integer，无返回值
 *         ObjLongConsumer<T> - 接收T和Long，无返回值
 *         LongConsumer - 接收Long，无返回值
 *
 * 2、Function<T, R> - 接收T对象，返回R对象
 *       BiFunction<T, U, R> - 接收T和U，返回R
 *         IntFunction<R> - 接收Integer，返回R
 *         IntToDoubleFunction - 接收Integer，返回double
 *         IntToLongFunction - 接收int，返回Long
 *         LongFunction<R> - 接收Long，返回R
 *         LongToDoubleFunction - 接收Long，返回Double
 *     	LongToIntFunction - 接收Long返回Integer
 * 		DoubleFunction<R> - 接收R，返回Double
 * 		DoubleToIntFunction - 接收Double，返回Integer
 * 		DoubleToLongFunction - 接收Double，返回Long
 *
 * 		ToIntFunction<T> - 接收T，返回Integer
 * 		ToIntBiFunction<T,U> - 接收T和U，返回Integer
 * 		ToLongFunction<T> - 接收T，返回Long
 * 		ToLongBiFunction<T,U> - 接收T和U，返回Long
 * 		ToDoubleBiFunction<T, U> - 接收T和U，返回Double
 * 		ToDoubleFunction<T> - 接收T，返回Double
 *
 * 3、UnaryPredicate<T> - 接收T，返回T
 * 	  Predicate<T> - 接收T对象，返回Boolean
 * 	  BiPredicate<T, U> - 接收T和U，返回Boolean
 * 		DoublePredicate - 接收Double，返回Boolean
 * 		IntPredicate - 接收int，返回Boolean
 * 		LongPredicate - 接收Long，返回Boolean
 *
 * 4、Supplier<T> - 提供T对象（例如工厂），无接收值
 * 		BooleanSupplier - 返回Boolean
 * 		DoubleSupplier - 返回Double
 * 		IntSupplier - 返回Integer
 * 		LongSupplier - 返回Long
 *
 * 5、UnaryOperator<T> - 接收T对象，返回T对象
 * 	  BinaryOperator<T> - 接收两个T对象，返回T对象
 * 		IntUnaryOperator - 接收一个Integer，返回Integer
 * 		IntBinaryOperator - 接收两个Integer，返回Integer
 * 		LongUnaryOperator - 接收一个Long，返回Long
 * 		LongBinaryOperator - 接收两个Long，返回Long
 * 		DoubleUnaryOperator - 接收一个Double，返回Double
 * 		DoubleBinaryOperator - 接收两个Double，返回Double
 *
 * 	函数式接口：只有一个接口方法（默认方法除外、Object下的方法除外）
 *
 * @author 王敏聪
 * @date 2019-08-09 11:05
 */
public class FunctionInterfaceDemo {

    public static void main(String[] args) {
//		FunctionInteface thisClass = new FunctionInteface();
    }

    /**
     * @FunctionalInterface，主要用于编译级错误检查，加上该注解，当你写的接口不符合函数式接口定义的时候，编译器会报错
     *
     * 加不加 @FunctionalInterface 对于接口是不是函数式接口没有影响，该注解只是提醒编译器去检查该接口是否仅包含一个抽象方法
     */
    @FunctionalInterface
    interface GreetingService {
        void sayMessage(String message);
    }

    /**
     * 使用Consumer传参的打印语句
     * @param obj
     */
    public static void println(Object obj) {
        Consumer<Object> consumer = System.out :: println;
        consumer.accept(obj);
    }

}
