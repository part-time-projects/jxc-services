package io.finer.erp.jeecg.bas.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.finer.erp.jeecg.bas.entity.BasMaterial;
import io.finer.erp.jeecg.bas.entity.TreeModel;
import io.finer.erp.jeecg.bas.service.IBasMaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

 /**
 * @Description: 物料
 * @Author: jeecg-boot
 * @Date:   2020-05-29
 * @Version: V1.0
 */
@Api(tags="物料")
@RestController
@RequestMapping("/bas/basMaterial")
@Slf4j
public class BasMaterialController extends JeecgController<BasMaterial, IBasMaterialService> {
	@Autowired
	private IBasMaterialService basMaterialService;
	
	/**
	 * 分页列表查询
	 *
	 * @param basMaterial
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "物料-分页列表查询")
	@ApiOperation(value="物料-分页列表查询", notes="物料-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(BasMaterial basMaterial,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<BasMaterial> queryWrapper = QueryGenerator.initQueryWrapper(basMaterial, req.getParameterMap());
		Page<BasMaterial> page = new Page<BasMaterial>(pageNo, pageSize);
		IPage<BasMaterial> pageList = basMaterialService.page(page, queryWrapper);
		return Result.ok(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param basMaterial
	 * @return
	 */
	@AutoLog(value = "物料-添加")
	@ApiOperation(value="物料-添加", notes="物料-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody BasMaterial basMaterial) {
		basMaterialService.save(basMaterial);
		return Result.ok("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param basMaterial
	 * @return
	 */
	@AutoLog(value = "物料-编辑")
	@ApiOperation(value="物料-编辑", notes="物料-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody BasMaterial basMaterial) {
		basMaterialService.updateById(basMaterial);
		return Result.ok("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "物料-通过id删除")
	@ApiOperation(value="物料-通过id删除", notes="物料-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		basMaterialService.removeById(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "物料-批量删除")
	@ApiOperation(value="物料-批量删除", notes="物料-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.basMaterialService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "物料-通过id查询")
	@ApiOperation(value="物料-通过id查询", notes="物料-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		BasMaterial basMaterial = basMaterialService.getById(id);
		if(basMaterial==null) {
			return Result.error("未找到对应数据");
		}
		return Result.ok(basMaterial);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param basMaterial
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, BasMaterial basMaterial) {
        return super.exportXls(request, basMaterial, BasMaterial.class, "物料");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, BasMaterial.class);
    }

	 /**
	  * 获取全部的权限树
	  *
	  * @return
	  */
	 @RequestMapping(value = "/queryTreeList", method = RequestMethod.GET)
	 public Result<Map<String, Object>> queryTreeList() {
		 Result<Map<String, Object>> result = new Result<>();
		 List<String> ids = new ArrayList<>();
		 try {
			 LambdaQueryWrapper<BasMaterial> query = new LambdaQueryWrapper<BasMaterial>();
//			 query.eq(BasMaterial::isEnabled, CommonConstant.STATUS_NORMAL);
//			 query.orderByAsc(SysPermission::getSortNo);
			 List<BasMaterial> list = basMaterialService.list(query);
			 for (BasMaterial sysPer : list) {
				 ids.add(sysPer.getId());
			 }
			 List<TreeModel> treeList = new ArrayList<>();
			 getTreeModelList(treeList, list, null);

			 Map<String, Object> resMap = new HashMap<String, Object>();
			 resMap.put("treeList", treeList); // 全部树节点数据
			 resMap.put("ids", ids);// 全部树ids
			 result.setResult(resMap);
			 result.setSuccess(true);
		 } catch (Exception e) {
			 log.error(e.getMessage(), e);
		 }
		 return result;
	 }

	 private void getTreeModelList(List<TreeModel> treeList, List<BasMaterial> metaList, TreeModel temp) {
		 for (BasMaterial basMaterial : metaList) {
			 String tempPid = basMaterial.getParentId();
			 TreeModel tree = new TreeModel(basMaterial);
			 if (temp == null && oConvertUtils.isEmpty(tempPid)) {
				 treeList.add(tree);
				 if (!tree.getIsLeaf()) {
					 getTreeModelList(treeList, metaList, tree);
				 }
			 } else if (temp != null && tempPid != null && tempPid.equals(temp.getKey())) {
				 temp.getChildren().add(tree);
				 if (!tree.getIsLeaf()) {
					 getTreeModelList(treeList, metaList, tree);
				 }
			 }

		 }
	 }
}
