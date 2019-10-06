package com.example.mybatis_plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    //    @TableId(type = IdType.ID_WORKER_STR)
//    private String id;
    @TableId(type = IdType.INPUT)
    private Long id;
    private String name;
    private Integer age;
    private String email;

//    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
//    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @Version
    private Integer version;
//
    @TableLogic
    private Integer deleted;

}
