package com.hugh.mallonline.coupon.dao;

import com.hugh.mallonline.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author hugh
 * @email hugh_zhan9@163.com
 * @date 2021-02-02 10:20:45
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
