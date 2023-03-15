package com.example.stums.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author XXX
 * @since 2022-11-10
 */
@Data
public class Student implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String name;

    private String className;

    private String major;

    private String sid;

    private String gender;

    private String password;

    private Date birthday;

    private String phone;

    private String mail;


}
