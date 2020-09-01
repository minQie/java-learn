package priv.wmc.study.jdk8.lambda;

import lombok.extern.slf4j.Slf4j;
import priv.wmc.study.jdk8.function_interface.MathOperationInteface;

/** 
 * 测试JDK8的lambda表达式
 * 
 * @author 王敏聪
 * @date 2019-08-09 14:10
 */
@Slf4j
public class LambdaDemo {
    
    public static void main(String[] args) {
        
        MathOperationInteface addition = Integer::sum;
        log.info(String.valueOf(addition.operation(2, 1)));
        
        MathOperationInteface subtraction = (a, b) -> a - b;
        log.info(String.valueOf(subtraction.operation(2, 1)));
        MathOperationInteface multiplication  = (int a, int b) -> { return a * b; };
        log.info(String.valueOf(multiplication.operation(2, 1)));

        MathOperationInteface division = (a, b) -> { return a / b; };
        log.info(String.valueOf(division.operation(2, 1)));
    }
}
