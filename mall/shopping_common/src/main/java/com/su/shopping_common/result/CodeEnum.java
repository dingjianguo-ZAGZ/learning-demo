package com.su.shopping_common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeEnum {
    SUCCESS(200,"成功"),
    SYSTEM_ERROR(500,"系统异常"),
    PARAMETER(601,"参数异常"),
    INSERT_PRODUCT_TYPE_ERROR(602,"3级类型商品不能添加子类型"),
    DELETE_PRODUCT_ERROR(603,"当前类型有子类型，不能删除"),
    UPLOAD_FILE_ERROR(604,"上传文件异常")
    ;

    private final Integer code;
    private final String message;


}
