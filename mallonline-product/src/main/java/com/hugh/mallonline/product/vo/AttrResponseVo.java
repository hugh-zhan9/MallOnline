package com.hugh.mallonline.product.vo;

import lombok.Data;

/**
 * Created by hugh on 2021/3/4
 */
@Data
public class AttrResponseVo extends AttrVo {

    private String catelogName;
    private String groupName;
    private Long catelogPath[];
}
