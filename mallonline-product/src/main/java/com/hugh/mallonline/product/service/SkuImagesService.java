package com.hugh.mallonline.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hugh.common.utils.PageUtils;
import com.hugh.mallonline.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author hugh
 * @email hugh_zhan9@163.com
 * @date 2021-02-01 13:01:02
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

