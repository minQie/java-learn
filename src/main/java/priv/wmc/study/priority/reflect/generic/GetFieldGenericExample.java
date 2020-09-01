package priv.wmc.study.priority.reflect.generic;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 先科普一下 ParameterizedType：
 * 1、这个是 Field 类的方法
 * 2、类中的成员变量使用了泛型（成员变量的类型定义有尖括号），那么这个成员变量通过反射获取的 Field 就是 ParameterizedType 的子类
 * （这就是判断某个类中的成员变量是否使用了泛型的一种判断条件）
 * 
 * @author 王敏聪
 * @date 2020-04-19 16:26
 */
@Slf4j
public class GetFieldGenericExample<T> {

    public T t;
    public List list;
    public List<?> wildList;
    public List<String> stringList;

    @Test
    public void test() {
        Field[] fields = this.getClass().getFields();
        for (Field field : fields) {
            getGenericFieldGenericType(field);
        }
    }

    /**
     * 获取使用了泛型的字段的真实泛型类型
     * 注意：就像类上注释强调的一样，一定得是涉及到尖括号的泛型使用，当前类中成员变量 t 和 list 是不算的
     */
    public void getGenericFieldGenericType(Field field) {
        Type fieldGenericType = field.getGenericType();

        /* 下面两种方式都可以校验，字段是否有使用泛型，但是要注意

         * 不要使用  sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl（原因见下边）
         * 而应该使用 java.lang.reflect.ParameterizedType
         *
         * SonarLint提示如下：
         * Classes in the sun.* or com.sun.* packages are considered implementation details, and are not part of the Java API.
         * They can cause problems when moving to new versions of Java because there is no backwards compatibility guarantee. Similarly, they can cause problems when moving to a different Java vendor, such as OpenJDK.
         * Such classes are almost always wrapped by Java API classes that should be used instead.
         */
//        if (!(genericType instanceof ParameterizedType)) {
        if (!ParameterizedType.class.isAssignableFrom(fieldGenericType.getClass())) {
            log.error("字段{}，没有使用泛型", field.getName());
            return;
        }
        // 指定泛型为 ? 的，下面的返回值是 WildcardTypeImpl，该类型是不能转成Class的（ClassCastException）
        // 指定了具体泛型的，下面的返回值是 Class
        Type actualTypeArgument = ((ParameterizedType)fieldGenericType).getActualTypeArguments()[0];
        log.info("字段{}，泛型类型为：{}", field.getName(), actualTypeArgument.getTypeName());
    }

}
