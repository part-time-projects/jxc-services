package io.finer.erp.jeecg.bas.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
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
import java.util.Date;

/**
 * @Description: 物料
 * @Author: jeecg-boot
 * @Date:   2020-05-29
 * @Version: V1.0
 */
@Data
@TableName("bas_material")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="bas_material对象", description="物料")
public class BasMaterialModel implements Serializable {
    private static final long serialVersionUID = 1L;

	/**ID*/
	@TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "ID")
    private String id;
	/**编码*/
	@Excel(name = "编码", width = 15)
    @ApiModelProperty(value = "编码")
    private String code;
	/**名称*/
	@Excel(name = "名称", width = 15)
    @ApiModelProperty(value = "名称")
    private String name;
	/**分类*/
	@Excel(name = "分类", width = 15, dictTable = "bas_material_category", dicText = "name", dicCode = "id")
	@Dict(dictTable = "bas_material_category", dicText = "name", dicCode = "id")
    @ApiModelProperty(value = "分类")
    private String categoryId;
	/**是否启用*/
	@Excel(name = "是否启用", width = 15, dicCode = "yn")
	@Dict(dicCode = "yn")
    @ApiModelProperty(value = "是否启用")
    private Integer isEnabled;
	/**规格型号*/
	@Excel(name = "规格型号", width = 15)
    @ApiModelProperty(value = "规格型号")
    private String model;
	/**计量单位*/
	@Excel(name = "计量单位", width = 15, dictTable = "bas_measure_unit", dicText = "name", dicCode = "id")
	@Dict(dictTable = "bas_measure_unit", dicText = "name", dicCode = "id")
    @ApiModelProperty(value = "计量单位")
    private String unitId;
	/**销售价格*/
	@Excel(name = "销售价格", width = 15)
    @ApiModelProperty(value = "销售价格")
    private BigDecimal salePrice;
	/**税控编码*/
	@Excel(name = "税控编码", width = 15)
    @ApiModelProperty(value = "税控编码")
    private String taxCode;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private String remark;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
	/**修改人*/
    @ApiModelProperty(value = "修改人")
    private String updateBy;
	/**修改时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
	/**版本*/
	@Excel(name = "版本", width = 15)
    @ApiModelProperty(value = "版本")
    private Integer version;

    /**
     * 父id
     */
    @Dict(dictTable = "bas_material", dicText = "name", dicCode = "id")
    @ApiModelProperty(value = "父物料")
    private String parentId;


    private Integer level;
    
}
