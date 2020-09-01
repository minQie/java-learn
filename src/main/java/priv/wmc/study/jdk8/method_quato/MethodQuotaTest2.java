package priv.wmc.study.jdk8.method_quato;

import org.junit.Test;

/**
 * @author Wang Mincong
 * @date 2020-08-04 23:21:46
 */
public class MethodQuotaTest2 {

    @Test
    public void test() {
        CustomConsumer<String> consumer = new MethodQuotaTest2()::function;

        CustomDoubleConsumer<String, String> doubleConsumer = new MethodQuotaTest2()::function;

        CustomTripleConsumer<String, String, String> tripleConsumer = new MethodQuotaTest2()::function;
    }

    public void function(String s) {}

    public void function(String s1, String s2) {}

    public void function(String s1, String s2, String s3) {}

    public interface CustomConsumer<I> {
        /**
         * Apply the function.
         * @param pInput the input for the function
         */
        void apply(I pInput);
    }

    public interface CustomDoubleConsumer<I, O> {
        /**
         * Apply the function.
         */
        void apply(I param1, O param2);
    }

    public interface CustomTripleConsumer<I, O, C> {
        /**
         * Apply the function.
         */
        void apply(I param1, O param2, C paramr3);
    }

}
