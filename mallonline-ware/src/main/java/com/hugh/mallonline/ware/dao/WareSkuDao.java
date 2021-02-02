package com.hugh.mallonline.ware.dao;

import com.hugh.mallonline.member.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author hugh
 * @email hugh_zhan9@163.com
 * @date 2021-02-02 11:22:08
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
