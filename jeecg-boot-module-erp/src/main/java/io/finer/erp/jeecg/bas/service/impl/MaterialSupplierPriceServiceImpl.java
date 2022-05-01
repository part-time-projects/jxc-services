package io.finer.erp.jeecg.bas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.finer.erp.jeecg.bas.entity.BasMaterialSupplierPrice;
import io.finer.erp.jeecg.bas.mapper.BasMaterialSupplierPriceMapper;
import io.finer.erp.jeecg.bas.service.IMaterialSupplierPriceService;

@Service
public class MaterialSupplierPriceServiceImpl extends ServiceImpl<BasMaterialSupplierPriceMapper, BasMaterialSupplierPrice>
        implements IMaterialSupplierPriceService {

    @Autowired
    private BasMaterialSupplierPriceMapper materialSupplierPriceMapper;

    @Override
    public List<String> getMaterialIdsBySupplierId(String supplierId) {
        return materialSupplierPriceMapper.queryMaterialIds(supplierId);
    }
}
