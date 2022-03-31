package io.finer.erp.jeecg.bas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import io.finer.erp.jeecg.bas.entity.BasMaterial;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

/**
 * @Description: 物料
 * @Author: jeecg-boot
 * @Date:   2020-05-29
 * @Version: V1.0
 */
public interface BasMaterialMapper extends BaseMapper<BasMaterial> {

    /**
     *   修改菜单状态字段： 是否子节点
     */
    @Update("update bas_material set leaf=#{leaf} where id = #{id}")
    public int setMenuLeaf(@Param("id") String id,@Param("leaf") int leaf);

}
