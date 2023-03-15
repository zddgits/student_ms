package com.example.stums.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.sql.Blob;
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
public class Notice implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String content;

    private Date time;

    private String title;

    private Blob image;

    private Integer deliverId;

    private String acceptor;


}
