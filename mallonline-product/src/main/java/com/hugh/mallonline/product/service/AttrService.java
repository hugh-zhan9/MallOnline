package com.hugh.mallonline.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hugh.common.utils.PageUtils;
import com.hugh.mallonline.product.entity.AttrEntity;
import com.hugh.mallonline.product.vo.AttrResponseVo;
import com.hugh.mallonline.product.vo.AttrVo;

import java.util.Map;

/**
 * 商品属性
 *
 * @author hugh
 * @email hugh_zhan9@163.com
 * @date 2021-02-01 13:01:02
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    PageUtils queryBaseAttrPage(String type, Map<String, Object> params, Long catelogId);

    AttrResponseVo getAttrInfo(Long attrId);

    void updateAttr(AttrVo attr);

}

