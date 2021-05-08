package com.micro.mall.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 批量操作方法验证器注解
 * @author QAQ
 * @date 2021/5/8
 */

public class BatchMethodClass implements ConstraintValidator<BatchMethod, String> {

    private String[] methods;
    @Override
    public void initialize(BatchMethod flagValidator) {
        this.methods = flagValidator.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null){
            return false;
        }
        for (String method: methods) {
            if (method.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
