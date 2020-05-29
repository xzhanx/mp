package com.example.mp.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.mp.enums.SexEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xzx
 * @since 2020/5/29
 */
@Data
@NoArgsConstructor
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Integer deleted;
    private SexEnum sex;

    public User(String name, Integer age, String email, SexEnum sex) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.sex = sex;
    }
}
