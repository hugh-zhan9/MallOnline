package com.hugh.mallonline.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hugh.common.utils.PageUtils;
import com.hugh.mallonline.member.entity.MemberReceiveAddressEntity;

import java.util.Map;

/**
 * 会员收货地址
 *
 * @author hugh
 * @email hugh_zhan9@163.com
 * @date 2021-02-02 11:12:58
 */
public interface MemberReceiveAddressService extends IService<MemberReceiveAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

