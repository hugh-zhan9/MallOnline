package com.hugh.mallonline.member.dao;

import com.hugh.mallonline.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author hugh
 * @email hugh_zhan9@163.com
 * @date 2021-02-02 11:12:58
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
