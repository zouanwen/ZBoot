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
@TableName("s_carousel")
public class SCarousel extends Model<SCarousel> {

    private static final long serialVersionUID = 1L;

    /**
     * 录播id
     */
    @TableId(value = "carousel_id", type = IdType.AUTO)
    private Integer carouselId;
    /**
     * 图片
     */
    @TableField("carousel_images")
    private String carouselImages;
    /**
     * 0:是首页 /1:是校友圈
     */
    @TableField("c_type")
    private Integer cType;
    /**
     * 时间
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
        return this.carouselId;
    }

}
