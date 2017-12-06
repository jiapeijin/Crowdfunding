package com.crowdfunding.framework.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Description: mybatis接口类注解
 *               项目启动时，mybatis会根据配置，扫描带有此注解的接口
 * @Auther： william
 * @Date：2017/6/6 0006 18:08
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MyBatisDao {

    String value() default "";

}
