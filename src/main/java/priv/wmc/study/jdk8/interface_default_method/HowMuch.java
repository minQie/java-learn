package priv.wmc.study.jdk8.interface_default_method;

/** 
 * @author Wang Mincong
 * @date 2019-08-24 16:23
 */
public class HowMuch implements One, Two {

    /* (non-Javadoc)
     * @see jdk8.default_method.One#howMuch()
     */
    @Override
    public void howMuch() {
        One.super.howMuch();
        Two.super.howMuch();
    }

}
