package com.zou.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zou
 * @since 2018-09-26
 */
@Data
@Accessors(chain = true)
@TableName("s_famous_class")
public class SFamousClass extends Model<SFamousClass> {

    private static final long serialVersionUID = 1L;

    /**
     * 名校分类id
     */
    @TableId(value = "class_id", type = IdType.AUTO)
    private Integer classId;
    /**
     * 分类名字
     */
    @TableField("class_name")
    private String className;
    /**
     * 分类图片
     */
    @TableField("class_images")
    private String classImages;
    /**
     * 创建时间
     */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @TableField("create_time")
    private Date createTime;
    /**
     * 创建时间
     */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @TableField("update_time")
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
        return this.classId;
    }

}
