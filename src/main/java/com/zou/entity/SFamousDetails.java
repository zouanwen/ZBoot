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
@TableName("s_famous_details")
public class SFamousDetails extends Model<SFamousDetails> {

    private static final long serialVersionUID = 1L;

    /**
     * 详情id
     */
    @TableId(value = "details_id", type = IdType.AUTO)
    private Integer detailsId;
    /**
     * 分类id
     */
    @TableField("class_id")
    private Integer classId;
    /**
     * 题目
     */
    @TableField("details_title")
    private String detailsTitle;
    /**
     * 详情图片
     */
    @TableField("details_images")
    private String detailsImages;
    /**
     * 内容
     */
    @TableField("details_content")
    private String detailsContent;
    /**
     * 浏览量
     */
    @TableField("details_browse")
    private Integer detailsBrowse;
    /**
     * 创建时间
     */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @TableField("update_time")
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
        return this.detailsId;
    }

}
