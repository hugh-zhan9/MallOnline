package com.hugh.mallonline.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hugh.common.constant.ProductConstant;
import com.hugh.mallonline.product.dao.AttrAttrgroupRelationDao;
import com.hugh.mallonline.product.dao.AttrGroupDao;
import com.hugh.mallonline.product.dao.CategoryDao;
import com.hugh.mallonline.product.entity.AttrAttrgroupRelationEntity;
import com.hugh.mallonline.product.entity.AttrGroupEntity;
import com.hugh.mallonline.product.entity.CategoryEntity;
import com.hugh.mallonline.product.service.CategoryService;
import com.hugh.mallonline.product.vo.AttrResponseVo;
import com.hugh.mallonline.product.vo.AttrVo;
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
    @Resource
    private CategoryService categoryService;

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
    public void saveAttr(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr,attrEntity);
        // 保存基本数据
        this.save(attrEntity);
        // 保存分组关系
        if (attr.getAttrGroupId() == ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()){
            AttrAttrgroupRelationEntity attrAttrgroupRelation = new AttrAttrgroupRelationEntity();
            attrAttrgroupRelation.setAttrGroupId(attr.getAttrGroupId());
            attrAttrgroupRelation.setAttrId(attrEntity.getAttrId());
            attrAttrgroupRelationDao.insert(attrAttrgroupRelation);
        }
    }

    /**
     * 分页查询参数信息同时查询所属分类与分组
     *
     * @param type
     * @param params 前端传递的查询参数
     * @param catelogId 参数ID
     * @return 分页查询对象
     */
    @Override
    public PageUtils queryBaseAttrPage(String type, Map<String, Object> params, Long catelogId) {
        QueryWrapper<AttrEntity> wrapper = new QueryWrapper<AttrEntity>().eq("attr_type","base".equalsIgnoreCase(type)?ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode():ProductConstant.AttrEnum.ATTR_TYPE_SALE.getCode());
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
        List<AttrResponseVo> attrResponseVoS = records.stream().map((attrEntity)->{
            AttrResponseVo attrResponseVO = new AttrResponseVo();
            BeanUtils.copyProperties(attrEntity,attrResponseVO);
            // 设置分类和分组的名称
            if ("base".equalsIgnoreCase(type)){
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

    @Override
    @Transactional
    public void updateAttr(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr,attrEntity);
        this.updateById(attrEntity);
        // 修改分组关联
        if (attrEntity.getAttrType() == ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()){
            AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
            relationEntity.setAttrGroupId(attr.getAttrGroupId());
            relationEntity.setAttrId(attr.getAttrId());

            Integer count = attrAttrgroupRelationDao.selectCount(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id",attr.getAttrId()));
            if (count > 0){
                attrAttrgroupRelationDao.update(relationEntity,new UpdateWrapper<AttrAttrgroupRelationEntity>().eq("attr_id",attr.getAttrId()));
            }else{
                attrAttrgroupRelationDao.insert(relationEntity);
            }
        }
    }

    @Override
    public AttrResponseVo getAttrInfo(Long attrId) {
        AttrResponseVo respVo = new AttrResponseVo();
        AttrEntity attrEntity = this.getById(attrId);
        BeanUtils.copyProperties(attrEntity,respVo);
        // 设置分组信息
        if (attrEntity.getAttrType() == ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()){
            AttrAttrgroupRelationEntity attrgroupRelation = attrAttrgroupRelationDao.selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id",attrId));
            if (attrgroupRelation != null){
                respVo.setAttrGroupId(attrgroupRelation.getAttrGroupId());
                AttrGroupEntity attrGroup = attrGroupDao.selectById(attrgroupRelation.getAttrGroupId());
                if (attrGroup != null){
                    respVo.setGroupName(attrGroup.getAttrGroupName());
                }
            }
        }
        // 设置分类信息
        Long catelogId = attrEntity.getCatelogId();
        Long[] catelogPath = categoryService.findCatelogPath(catelogId);
        respVo.setCatelogPath(catelogPath);
        CategoryEntity categoryEntity = categoryDao.selectById(catelogId);
        if (categoryEntity != null){
            respVo.setCatelogName(categoryEntity.getName());
        }
        return respVo;
    }

}