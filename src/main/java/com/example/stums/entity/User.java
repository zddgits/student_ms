package com.example.stums.entity;

import lombok.Data;

/**
 * @author darkFernMoss
 * since 2022/11/11
 * at project student_ms
 *
 * 该类为通用用户类
 */
@Data
public class User {
    //学工号
    private Integer work_id;

    private String name;

    private String password;

    // 判断用户角色，0是admin，1是student，2是teacher
    private int type;

}
