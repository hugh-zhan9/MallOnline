package com.hugh.mallonline.product.feign;

import com.hugh.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by hugh on 2021/2/2
 */

@FeignClient("mallonline-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/list")
    R list(@RequestParam Map<String, Object> params);
}
