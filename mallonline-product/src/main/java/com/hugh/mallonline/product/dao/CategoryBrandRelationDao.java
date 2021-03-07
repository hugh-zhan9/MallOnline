package com.hugh.mallonline.product.dao;

import com.hugh.mallonline.product.entity.CategoryBrandRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * 品牌分类关联
 * 
 * @author hugh
 * @email hugh_zhan9@163.com
 * @date 2021-02-01 13:01:02
 */
@Mapper
public interface CategoryBrandRelationDao extends BaseMapper<CategoryBrandRelationEntity> {

    @Update("update pms_category_brand_relation set catelog_name = #{name} WHERE catelog_id = #{id}")
    void updateCategory(@Param("id") Long catId, @Param("name") String name);
}
