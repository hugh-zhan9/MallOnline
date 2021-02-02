package com.hugh.mallonline.ware.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hugh.mallonline.ware.entity.PurchaseEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 采购信息
 * 
 * @author hugh
 * @email hugh_zhan9@163.com
 * @date 2021-02-02 11:22:08
 */
@Mapper
public interface PurchaseDao extends BaseMapper<PurchaseEntity> {
	
}
