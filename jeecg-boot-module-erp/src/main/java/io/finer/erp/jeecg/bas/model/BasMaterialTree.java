package io.finer.erp.jeecg.bas.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.finer.erp.jeecg.bas.entity.BasMaterial;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecg.common.aspect.annotation.Dict;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 物料
 * @Author: gmb
 * @Date:   2022-04-01
 * @Version: V1.0
 */


public class BasMaterialTree implements Serializable {
    private static final long serialVersionUID = 1L;


    private String id;

    private String code;

    private String name;

    private String categoryId;

    private Integer isEnabled;

    private String model;

    private String unitId;

    private BigDecimal salePrice;

    private String taxCode;

    private String remark;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private Integer version;

    private String parentId;

    /**
     * 是否叶子节点: 1:是  0:不是
     */
    private boolean leaf = true;

    private List<BasMaterialTree> children;


    public BasMaterialTree(BasMaterial basMaterial) {
        this.id = basMaterial.getId();
        this.code = basMaterial.getCode();
        this.name = basMaterial.getName();
        this.categoryId = basMaterial.getCategoryId();
        this.isEnabled = basMaterial.getIsEnabled();
        this.model = basMaterial.getModel();
        this.unitId = basMaterial.getUnitId();
        this.salePrice = basMaterial.getSalePrice();
        this.taxCode = basMaterial.getTaxCode();
        this.remark = basMaterial.getRemark();
        this.createBy = basMaterial.getCreateBy();
        this.createTime = basMaterial.getCreateTime();
        this.updateBy = basMaterial.getUpdateBy();
        this.updateTime = basMaterial.getUpdateTime();
        this.version = basMaterial.getVersion();
        this.parentId = basMaterial.getParentId();
        this.leaf = basMaterial.isLeaf();
        if (!basMaterial.isLeaf()) {
            this.children = new ArrayList<BasMaterialTree>();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public List<BasMaterialTree> getChildren() {
        return children;
    }

    public void setChildren(List<BasMaterialTree> children) {
        this.children = children;
    }
}
