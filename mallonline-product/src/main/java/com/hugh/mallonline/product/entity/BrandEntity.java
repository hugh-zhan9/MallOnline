package com.hugh.mallonline.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import com.hugh.common.valid.AddGroup;
import com.hugh.common.valid.ListValue;
import com.hugh.common.valid.UpdateGroup;
import com.hugh.common.valid.UpdateStatusGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author hugh
 * @email hugh_zhan9@163.com
 * @date 2021-02-01 13:01:02
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	@Null(message = "新增时必须为空", groups= {AddGroup.class})
	@NotNull(message = "修改时不能为空", groups = {UpdateGroup.class})	// groups参数进行分组校验；
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名不能为空", groups = {UpdateGroup.class, AddGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotEmpty(groups = {AddGroup.class})
	@URL(message = "URL必须是一个合法的url地址", groups = {UpdateGroup.class, AddGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 *
	 * Integer不支持正则校验，所以这里可以自定义校验
	 * 1。 自定义一个校验注解
	 * 2. 自定义一个校验器
	 * 3. 关联自定义的校验注解和校验器
	 */
	// @Pattern()
	@NotNull(groups = {AddGroup.class, UpdateStatusGroup.class})
	@ListValue(values = {0,1}, groups = {AddGroup.class, UpdateStatusGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotEmpty(groups = {AddGroup.class})
	@Pattern(regexp = "^[a-zA-Z]$", message = "检索首字母必须是一个字母", groups = {UpdateGroup.class, AddGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(groups = {AddGroup.class})
	@Min(value = 0, message = "排序必须大于等于零", groups = {UpdateGroup.class, AddGroup.class})
	private Integer sort;

}
