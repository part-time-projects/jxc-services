package io.finer.erp.jeecg.bas.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import io.finer.erp.jeecg.bas.entity.BasMaterialSupplierPrice;

public interface IMaterialSupplierPriceService extends IService<BasMaterialSupplierPrice> {
    List<String> getMaterialIdsBySupplierId(String supplierId);
}
