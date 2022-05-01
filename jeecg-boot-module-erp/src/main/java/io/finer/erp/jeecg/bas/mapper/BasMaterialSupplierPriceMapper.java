package io.finer.erp.jeecg.bas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import io.finer.erp.jeecg.bas.entity.BasMaterialSupplierPrice;

public interface BasMaterialSupplierPriceMapper extends BaseMapper<BasMaterialSupplierPrice> {

    List<String> queryMaterialIds(@Param("supplierId") String supplierId);
}
