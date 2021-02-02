package com.hugh.mallonline.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hugh.common.utils.PageUtils;
import com.hugh.mallonline.member.entity.PurchaseEntity;

import java.util.Map;

/**
 * 采购信息
 *
 * @author hugh
 * @email hugh_zhan9@163.com
 * @date 2021-02-02 11:22:08
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

