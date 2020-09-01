package priv.wmc.study.basic.exception;

import org.junit.Test;

/**
 * <ul><b>Error</b>
 *    <li>概念：包括一些严重的程序不能处理的系统错误类，如内存溢出、虚拟机错误、栈溢出等。
 *    这类错误一般与硬件有关，与程序本身无关，通常由系统进行处理，程序本身无法捕获和处理（所以Error是Uncheck的）。
 *    常见的error有：NotClassDeFountError(类未定义错误)，OutOfMemoryError(内存溢出错误)，StackOverFlowError(栈溢出错误)
 *    </li>
 * </ul>
 *
 * <ul><b>Checked Exception</b>
 *    <li>概念：指的是不能恢复，必须要被使用者来处理的一类异常，如果不捕获，那么编译会报错。</li>
 *    <li>语法定义：Exception 或者 符合Exception的子类中继承链分析中不含RuntimeException的。</li>
 * </ul>
 *
 * <ul><b>Unchecked Exception</b>
 *     <li>概念：指的是在运行时才会导致程序奔溃的异常，编译时候并不会报错。
 *     <li>语法定义：RuntimeException 或 RuntimeException的子类。
 * </ul>
 *
 * <ol><b>点</b>
 *    <li>
 *        个人的误区、理解：程序运行时，无论是 Checked Exception 还是 Unchecked Exception 都会导致当前正在运行的方法的中止，
 *        方法抛出的异常，如果自身不处理，则交由方法的调用者处理，一次类推。如果到了最顶层方法，如程序入口的main方法，或者其他线程的run方法，则会导致进程的结束
 *    </li>
 *    </li>
 *    <li>
 *        Checked Exception需要显示的捕获（try）或者在方法上声明（catch），
 *        Unchecked Exception则不需要，但是为Unchecked Exception在方法上声明，是符合java语法的（能够通过编译）
 *        <p>下边的两条诠释了该点</p>
 *
 *        <p><b>java:S1130</b>
 *          <p>An exception in a throws declaration in Java is superfluous if it is:
 *          <p>listed multiple times
 *          <p>a subclass of another listed exception
 *          <p>a RuntimeException, or one of its descendants
 *          <p>completely unnecessary because the declared exception type cannot actually be thrown
 *          <p>
 *          <p>The rule will not raise any issue for exceptions that cannot be thrown from the method body:
 *          <p>in overriding and implementation methods
 *          <p>in interface default methods
 *          <p>in non-private methods that only throw, have empty bodies, or a single return statement .
 *          <p>in overridable methods (non-final, or not member of a final class, non-static, non-private), if the exception is documented with a proper javadoc.
 *    </li>
 * </ol>
 *
 * @author Wang Mincong
 * @date 2020-07-29 22:39:25
 */
public class CheckedAndUncheckTest {

    @Test
    public void test() {
        // jdk7 新增了 multi catch 的捕获形式，但是规则是 multi catch 的catch中的异常类型声明不能有子父关系
        try {
            throwNpe();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException");
        }
    }

    private void throwNpe() {
        throw new NullPointerException("null value");
    }

}
