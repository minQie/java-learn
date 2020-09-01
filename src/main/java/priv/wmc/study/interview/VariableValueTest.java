package priv.wmc.study.interview;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 不能理所当然的i值变了，所有计算的相关的值就变了，前置++，是先改变变量值，再将值进栈，后置++正好相反
 *
 * 总结：只"凭感觉"考虑运算符优先级的答案是完全错误的，要清晰的知道底层原理
 *
 * 深思：你计算的是一个算术表达式的值，请别傻吊，欸，就这样这样就算出来了，
 * 这样说”算术表达式 → 运算符优先级 → 数据结构学过的“没能这样联想，还算屁，肯定凉凉
 *
 * @author Wang Mincong
 * @date 2020-08-19 15:51:28
 */
@Slf4j
public class VariableValueTest {

    @Test
    public void test() {
        int a = 1;
        int b = a++;
        // a(2) b(1)

        int i = 1;
        // i(1)


        i = i++;
        /* i的值为2 - 错误
         * 可以得到idea给出的警告提示：The value changed at 'i++' is never used
         *
         * 详解：你的脑袋里一定得有java的内存模型
         * int a = 1;
         * int b = a++;
         *
         * 0、局部变量表的a的值为1
         * 1、将a的值进栈（1）
         * 2、局部变量表的a自增（2）
         * 3、将栈中的值赋值给赋值给b（1）
         *
         * 如果是 int b = ++a;
         *
         * 0、局部变量表的a的值为1
         * 1、将a的值进栈（1）
         * 2、局部变量表的a自增（2）后进栈
         * 3、将栈中的值赋值给赋值给b（2）
         */

        int j = i++;
        // i(2) j(1)


        int k = i + ++i * i++;

        /* 解析到第一个i进栈（2）
         * 加号进运算符栈
         * 解析到第二个i自增后进栈（3）
         * 乘号要进栈和加号比对优先级 - 不用调整
         * 解析到第三个i进栈（3）后自增（4）
         * i(4) j(1) k(2 + 3 * 3 = 13)
         */

        log.info("i="+i);
        log.info("j="+j);
        log.info("k="+k);
    }

}
