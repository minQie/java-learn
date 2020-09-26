package priv.wmc.study.senior.reflect.field;

/**
 * 介绍一些关于Field的工具方法
 *
 * Spring相关的工具类有：BeanUtils、ClassUtils、ReflectionUtils
 * Apache lang3相关的工具类有：FieldUtils
 *
 * <p>spring ReflectionUtils.findField（和原生jdk的getField相比，能够无视权限修饰符，向上递归查找直至Object）
 * <p>spring ReflectionUtils.getDeclaredFields（和原生jdk相比，就是加了一道缓存）
 * <p>lang3 FieldUtils.getFieldsListWithAnnotation
 *
 * @author Wang Mincong
 * @date 2020-01-12 10:31
 */
public final class ReflectUtilConcept {

    private ReflectUtilConcept() {}

}
