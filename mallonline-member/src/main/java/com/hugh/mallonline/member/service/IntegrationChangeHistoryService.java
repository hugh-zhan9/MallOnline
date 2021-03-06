package com.hugh.mallonline.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hugh.common.utils.PageUtils;
import com.hugh.mallonline.member.entity.IntegrationChangeHistoryEntity;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author hugh
 * @email hugh_zhan9@163.com
 * @date 2021-02-02 11:12:58
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

