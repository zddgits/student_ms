package com.example.stums.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Admin implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String name;

    private String password;

    private String phone;


}
