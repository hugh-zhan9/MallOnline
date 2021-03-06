package com.hugh.mallonline.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hugh.common.utils.PageUtils;
import com.hugh.mallonline.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author hugh
 * @email hugh_zhan9@163.com
 * @date 2021-02-02 11:12:58
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

