package com.hugh.mallonline.product.dao;

import com.hugh.mallonline.product.entity.SkuInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * sku信息
 * 
 * @author hugh
 * @email hugh_zhan9@163.com
 * @date 2021-02-01 13:01:02
 */
@Mapper
public interface SkuInfoDao extends BaseMapper<SkuInfoEntity> {
	
}