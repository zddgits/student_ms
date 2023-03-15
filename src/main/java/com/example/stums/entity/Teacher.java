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
public class Teacher implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String name;

    private String password;

    private String mail;

    private String major;

    private String sid;

    private String gender;

    private Date birth;

    private String phone;


}
