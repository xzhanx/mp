package com.example.mp.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author xzx
 * @since 2020/5/29
 */
@Getter
public enum SexEnum {

    man(0, "男"),
    women(1, "女");

    @EnumValue
    private final int code;
    private final String name;

    SexEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
