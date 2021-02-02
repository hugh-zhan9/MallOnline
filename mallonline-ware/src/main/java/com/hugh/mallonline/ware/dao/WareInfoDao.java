package com.hugh.mallonline.ware.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hugh.mallonline.ware.entity.WareInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 仓库信息
 * 
 * @author hugh
 * @email hugh_zhan9@163.com
 * @date 2021-02-02 11:22:08
 */
@Mapper
public interface WareInfoDao extends BaseMapper<WareInfoEntity> {
	
}
