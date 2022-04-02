package io.finer.erp.jeecg.bas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.finer.erp.jeecg.bas.entity.BasMaterial;
import io.finer.erp.jeecg.bas.mapper.BasMaterialMapper;
import io.finer.erp.jeecg.bas.service.IBasMaterialService;
import org.jeecg.common.constant.CacheConstant;
import org.jeecg.common.constant.CommonConstant;
import org.jeecg.common.exception.JeecgBootException;
import org.jeecg.common.util.oConvertUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 物料
 * @Author: jeecg-boot
 * @Date:   2020-05-29
 * @Version: V1.0
 */
@Service
public class BasMaterialServiceImpl extends ServiceImpl<BasMaterialMapper, BasMaterial> implements IBasMaterialService {

    static  final  int MATERIAL_LEVEL = 1;
    @Resource
    private BasMaterialMapper basMaterialMapper;

    @Override
    public void addBasMaterial(BasMaterial basMaterial) throws JeecgBootException {

        //----------------------------------------------------------------------
        String pid = basMaterial.getParentId();
        if(oConvertUtils.isNotEmpty(pid)) {
            this.basMaterialMapper.setMenuLeaf(pid, 0);
            basMaterial.setLevel(MATERIAL_LEVEL);
        }
        basMaterial.setLeaf(true);
        this.save(basMaterial);
    }

    @Override
    public void editBasMaterial(BasMaterial basMaterial) throws JeecgBootException {
        /**
         * 原则：当前修改物料如果有子节点，需要更新当前物料为不是叶子节点；
         *      如果修改了parentId的俩种情况：1.根据老的parentId是否有子节点 判断是否更新为叶子节点
         *                                2.更新当前父节点为不是叶子节点
         * */
        BasMaterial p = this.getById(basMaterial.getId());
        if(p==null) {
            throw new JeecgBootException("未找到物料信息");
        }else {
            basMaterial.setUpdateTime(new Date());
            int count = this.count(new QueryWrapper<BasMaterial>().lambda().eq(BasMaterial::getParentId, basMaterial.getId()));
            if(count==0) {
                basMaterial.setLeaf(true);
            }
            //----------------------------------------------------------------------
            this.updateById(basMaterial);

            //如果当前菜单的父菜单变了，则需要修改新父菜单和老父菜单的，叶子节点状态
            String pid = basMaterial.getParentId();
            if((oConvertUtils.isNotEmpty(pid) && !pid.equals(p.getParentId())) || oConvertUtils.isEmpty(pid)&&oConvertUtils.isNotEmpty(p.getParentId())) {
                basMaterial.setLevel(MATERIAL_LEVEL);
                //a.设置新的父菜单不为叶子节点
                this.basMaterialMapper.setMenuLeaf(pid, 0);
                //b.判断老的菜单下是否还有其他子菜单，没有的话则设置为叶子节点
                int cc = this.count(new QueryWrapper<BasMaterial>().lambda().eq(BasMaterial::getParentId, p.getParentId()));
                if(cc==0) {
                    if(oConvertUtils.isNotEmpty(p.getParentId())) {
                        this.basMaterialMapper.setMenuLeaf(p.getParentId(), 1);
                    }
                }

            }
        }

    }


    @Override
    @Transactional
    public void deleteBasMaterial(String id) throws JeecgBootException {
        BasMaterial basMaterial = this.getById(id);
        if(basMaterial==null) {
            throw new JeecgBootException("未找到菜单信息");
        }
        String pid = basMaterial.getParentId();
        if(oConvertUtils.isNotEmpty(pid)) {
            int count = this.count(new QueryWrapper<BasMaterial>().lambda().eq(BasMaterial::getParentId, pid));
            if(count==1) {
                //若父节点无其他子节点，则该父节点是叶子节点
                this.basMaterialMapper.setMenuLeaf(pid, 1);
            }
        }
        basMaterialMapper.deleteById(id);
        // 级联删除
        this.removeChildrenBy(basMaterial.getId());
    }


    /**
     * 级联删除
     * @return
     */
    public void removeChildrenBy(String parentId) {
        LambdaQueryWrapper<BasMaterial> query = new LambdaQueryWrapper<>();
        query.eq(BasMaterial::getParentId, parentId);
        List<BasMaterial> permissionList = this.list(query);
        if (permissionList != null && permissionList.size() > 0) {
            String id = "";
            int num = 0;
            this.remove(query);
            for (int i = 0, len = permissionList.size(); i < len; i++) {
                id = permissionList.get(i).getId();
                Map map = new HashMap<>();
                map.put("permission_id",id);
                //删除部门角色授权
                num = this.count(new LambdaQueryWrapper<BasMaterial>().eq(BasMaterial::getParentId, id));
                // 如果有, 则递归
                if (num > 0) {
                    this.removeChildrenBy(id);
                }
            }
        }
    }

}
