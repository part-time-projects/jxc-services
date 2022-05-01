package io.finer.erp.jeecg.bas.entity;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@TableName("bas_material_supplier_price")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="对象", description="物料供应商价格")
public class BasMaterialSupplierPrice  implements Serializable {
    /**ID*/
    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "ID")
    private java.lang.String id;
    /**物料ID*/
    @ApiModelProperty(value = "物料")
    private java.lang.String materialId;
    /**供应商ID*/
    @ApiModelProperty(value = "供应商")
    private java.lang.String supplierId;
    /**销售价格*/
    @ApiModelProperty(value = "销售价格")
    private java.math.BigDecimal salePrice;
    /**备注*/
    @ApiModelProperty(value = "备注")
    private java.lang.String remark;
    /**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createName;
    /**创建时间*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createDate;
    /**修改人*/
    @ApiModelProperty(value = "修改人")
    private java.lang.String updateName;
    /**修改时间*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "修改时间")
    private java.util.Date updateDate;
}
