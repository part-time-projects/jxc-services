package io.finer.erp.jeecg.finance.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**·
 * @Description: 应收单
 * @Author: jeecg-boot
 * @Date:   2020-04-30
 * @Version: V1.0
 */
@Data
@TableName("fin_receivable")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="fin_receivable对象", description="应收单")
public class FinReceivable implements Serializable {
    private static final long serialVersionUID = 1L;

	/**ID*/
	@TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "ID")
    private java.lang.String id;
	/**单据编号*/
	@Excel(name = "单据编号", width = 15)
    @ApiModelProperty(value = "单据编号")
    private java.lang.String billNo;
	/**单据日期*/
	@Excel(name = "单据日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "单据日期")
    private java.util.Date billDate;
	/**应收类型*/
	@Excel(name = "应收类型", width = 15, dicCode = "x_receivable_type")
	@Dict(dicCode = "x_receivable_type")
	@ApiModelProperty(value = "应收类型")
	private java.lang.String receivableType;
	/**是否自动生成*/
	@Excel(name = "是否自动生成", width = 15, dicCode = "yn")
	@Dict(dicCode = "yn")
    @ApiModelProperty(value = "是否自动生成")
    private java.lang.Integer isAuto;
	/**源单类型*/
	@Excel(name = "源单类型", width = 15, dicCode = "x_bill_type")
	@Dict(dicCode = "x_bill_type")
    @ApiModelProperty(value = "源单类型")
    private java.lang.String sourceType;
	/**是否红字*/
	@Excel(name = "是否红字", width = 15, dicCode = "yn")
	@Dict(dicCode = "yn")
	@ApiModelProperty(value = "是否红字")
	private java.lang.Integer isRubric;
	/**源单号*/
	@Excel(name = "源单号", width = 15)
    @ApiModelProperty(value = "源单号")
    private java.lang.String sourceNo;
	/**源单id*/
	@Excel(name = "源单id", width = 15)
    @ApiModelProperty(value = "源单id")
    private java.lang.String sourceId;
	/**客户*/
	@Excel(name = "客户", width = 15, dictTable = "bas_customer", dicText = "name", dicCode = "id")
	@Dict(dictTable = "bas_customer", dicText = "name", dicCode = "id")
    @ApiModelProperty(value = "客户")
    private java.lang.String customerId;
	/**金额*/
	@Excel(name = "金额", width = 15)
    @ApiModelProperty(value = "金额")
    private java.math.BigDecimal amt;
	/**已核销金额*/
	@Excel(name = "已核销金额", width = 15)
    @ApiModelProperty(value = "已核销金额")
    private java.math.BigDecimal checkedAmt;
	/**附件*/
	@Excel(name = "附件", width = 15)
	@ApiModelProperty(value = "附件")
	private java.lang.String attachment;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String remark;
	/**处理状态*/
	@Excel(name = "处理状态", width = 15, dicCode = "x_bill_proc_status")
	@Dict(dicCode = "x_bill_proc_status")
    @ApiModelProperty(value = "处理状态")
    private java.lang.String billProcStatus;
	/**是否通过*/
	@Excel(name = "是否通过", width = 15, dicCode = "yn")
	@Dict(dicCode = "yn")
    @ApiModelProperty(value = "是否通过")
    private java.lang.Integer isApproved;
	/**是否关闭*/
	@Excel(name = "是否关闭", width = 15, dicCode = "yn")
	@Dict(dicCode = "yn")
    @ApiModelProperty(value = "是否关闭")
    private java.lang.Integer isClosed;
	/**是否作废*/
	@Excel(name = "是否作废", width = 15, dicCode = "yn")
	@Dict(dicCode = "yn")
    @ApiModelProperty(value = "是否作废")
    private java.lang.Integer isVoided;
	/**审核人*/
	@Excel(name = "审核人", width = 15, dictTable = "sys_user", dicText = "realname", dicCode = "username")
	@Dict(dictTable = "sys_user", dicText = "realname", dicCode = "username")
    @ApiModelProperty(value = "审核人")
    private java.lang.String approverId;
	/**流程id*/
	@Excel(name = "流程id", width = 15)
    @ApiModelProperty(value = "流程id")
    private java.lang.String flowId;
	/**生效时间*/
	@Excel(name = "生效时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "生效时间")
    private java.util.Date effectiveTime;
	/**创建部门*/
	@Excel(name = "创建部门", width = 15)
    @ApiModelProperty(value = "创建部门")
    private java.lang.String sysOrgCode;
	/**创建人*/
	@Excel(name = "创建人", width = 15, dictTable = "sys_user", dicText = "realname", dicCode = "username")
	@Dict(dictTable = "sys_user", dicText = "realname", dicCode = "username")
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建时间*/
	@Excel(name = "创建时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;
	/**修改人*/
	@Excel(name = "修改人", width = 15, dictTable = "sys_user", dicText = "realname", dicCode = "username")
	@Dict(dictTable = "sys_user", dicText = "realname", dicCode = "username")
    @ApiModelProperty(value = "修改人")
    private java.lang.String updateBy;
	/**修改时间*/
	@Excel(name = "修改时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "修改时间")
    private java.util.Date updateTime;
	/**版本*/
    @ApiModelProperty(value = "版本")
    private java.lang.Integer version;

	/**未核销金额*/
	@TableField(exist = false)
	private java.math.BigDecimal uncheckedAmt;

	@TableField(exist = false)
	private Map actionsEnabled;

	public BigDecimal getUncheckedAmt() {
		//controller中，QueryWrapper也会创建entity；
		//(uncheckedAmt == null)，是为了避免作为查询数据库参数。
		return id == null ? null : amt.subtract(checkedAmt);
	}

	public Map getActionsEnabled() {
		//controller中，QueryWrapper也会创建entity；
		//(actionsEnabled == null)，是为了避免作为查询数据库参数。
		if (id == null) {
			return null;
		}

		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		boolean b = billProcStatus != null && billProcStatus.startsWith("1")
				&& (isApproved == null || isApproved == 0)
				&& (isClosed == null || isClosed == 0)
				&& (isVoided == null || isVoided == 0);
		map.put("edit", b);

		b = billProcStatus != null &&
				billProcStatus.startsWith("1") && !billProcStatus.equals("13")
				&& (isApproved == null || isApproved == 0)
				&& (isClosed == null || isClosed == 0)
				&& (isVoided == null || isVoided == 0)
				&&  approverId == null;
		map.put("delete", b);

		b =  billProcStatus != null && billProcStatus.equals("13")
				&& (isApproved == null || isApproved == 0)
				&& (isClosed == null || isClosed == 0)
				&& (isVoided == null || isVoided == 0);
		map.put("approve", b);

		b = billProcStatus != null &&
				(billProcStatus.equals("23") ||
						billProcStatus.startsWith("3") && !billProcStatus.equals("33"))
				&& isApproved != null && isApproved == 1
				&& (isClosed == null || isClosed == 0)
				&& (isVoided == null || isVoided == 0);
		map.put("execute", b);

		actionsEnabled = map;
		return map;
	}
}
