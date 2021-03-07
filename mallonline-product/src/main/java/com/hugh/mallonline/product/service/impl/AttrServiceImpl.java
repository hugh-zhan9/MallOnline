package com.hugh.mallonline.product.service.impl;

import com.hugh.mallonline.product.dao.AttrAttrgroupRelationDao;
import com.hugh.mallonline.product.dao.AttrGroupDao;
import com.hugh.mallonline.product.dao.CategoryDao;
import com.hugh.mallonline.product.entity.AttrAttrgroupRelationEntity;
import com.hugh.mallonline.product.entity.AttrGroupEntity;
import com.hugh.mallonline.product.entity.CategoryEntity;
import com.hugh.mallonline.product.vo.AttrResponseVO;
import com.hugh.mallonline.product.vo.AttrVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hugh.common.utils.PageUtils;
import com.hugh.common.utils.Query;

import com.hugh.mallonline.product.dao.AttrDao;
import com.hugh.mallonline.product.entity.AttrEntity;
import com.hugh.mallonline.product.service.AttrService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Resource
    private AttrAttrgroupRelationDao attrAttrgroupRelationDao;
    @Resource
    private AttrGroupDao attrGroupDao;
    @Resource
    private CategoryDao categoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public void saveAttr(AttrVO attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr,attrEntity);
        this.save(attrEntity);
        AttrAttrgroupRelationEntity attrAttrgroupRelation = new AttrAttrgroupRelationEntity();
        attrAttrgroupRelation.setAttrGroupId(attr.getAttrGroupId());
        attrAttrgroupRelation.setAttrId(attrEntity.getAttrId());
        attrAttrgroupRelationDao.insert(attrAttrgroupRelation);
    }

    /**
     * 分页查询参数信息同时查询所属分类与分组
     * @param params 前端传递的查询参数
     * @param catelogId 参数ID
     * @return 分页查询对象
     */
    @Override
    public PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId) {
        QueryWrapper<AttrEntity> wrapper = new QueryWrapper<AttrEntity>();
        if (catelogId != 0){
            wrapper.eq("catelog_id", catelogId);
        }
        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)){
            wrapper.and((qw)->qw.eq("attr_id", key).like("attr_name", key) );
        }
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                wrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        List<AttrEntity> records = page.getRecords();
        List<AttrResponseVO> attrResponseVoS = records.stream().map((attrEntity)->{
            AttrResponseVO attrResponseVO = new AttrResponseVO();
            BeanUtils.copyProperties(attrEntity,attrResponseVO);
            // 设置分类和分组的名称
            AttrAttrgroupRelationEntity attrGroup = attrAttrgroupRelationDao.selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>()
                            .eq("attr_id",attrEntity.getAttrId())
            );
            if (attrGroup != null){
                Long groupId = attrGroup.getAttrGroupId();
                if (groupId != null){
                    AttrGroupEntity group = attrGroupDao.selectById(groupId);
                    attrResponseVO.setGroupName(group.getAttrGroupName());
                }
            }
            CategoryEntity category = categoryDao.selectById(attrEntity.getCatelogId());
            if (category != null){
                attrResponseVO.setCatelogName(category.getName());
            }
            return attrResponseVO;
        }).collect(Collectors.toList());
        pageUtils.setList(attrResponseVoS);
        return pageUtils;
    }

}