package com.hugh.mallonline.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hugh.common.utils.PageUtils;
import com.hugh.mallonline.member.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author hugh
 * @email hugh_zhan9@163.com
 * @date 2021-02-02 11:22:08
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

