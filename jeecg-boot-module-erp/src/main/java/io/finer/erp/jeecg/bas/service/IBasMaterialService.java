package io.finer.erp.jeecg.bas.service;

import io.finer.erp.jeecg.bas.entity.BasMaterial;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.common.exception.JeecgBootException;

/**
 * @Description: 物料
 * @Author: jeecg-boot
 * @Date:   2020-05-29
 * @Version: V1.0
 */
public interface IBasMaterialService extends IService<BasMaterial> {

    public void addBasMaterial(BasMaterial basMaterial) throws JeecgBootException;

    public void editBasMaterial(BasMaterial basMaterial) throws JeecgBootException;

    public void deleteBasMaterial(String id) throws JeecgBootException ;


}
