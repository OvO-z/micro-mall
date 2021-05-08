package com.micro.mall.common.validator;

import com.micro.mall.common.constant.BatchConstant;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 批量操作方法验证器注解
 * @author QAQ
 * @date 2021/5/8
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = BatchMethodClass.class)
public @interface BatchMethod {
    String[] value() default {BatchConstant.CREATE, BatchConstant.DELETE, BatchConstant.UPDATE};

    String message() default "batch method error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
