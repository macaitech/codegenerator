package com.macaitech.codegenerator.gen.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.macaitech.codegenerator.gen.entity.GenScheme;
import com.macaitech.codegenerator.gen.service.GenSchemeService;
import com.macaitech.codegenerator.gen.service.GenTableService;
import com.macaitech.codegenerator.gen.util.GenUtils;
import com.macaitech.common.utils.StringUtils;
import com.macaitech.common.web.BaseController;

/**
 * 生成方案Controller
 * @author ThinkGem
 * @version 2013-10-15
 */
@Controller
@RequestMapping(value = "/gen/genScheme")
public class GenSchemeController extends BaseController {

	@Autowired
	private GenSchemeService genSchemeService;
	
	@Autowired
	private GenTableService genTableService;
	
	@ModelAttribute
	public GenScheme get(@RequestParam(required=false) Long id) {
		if (id != null){
			return genSchemeService.get(id);
		}else{
			return new GenScheme();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(GenScheme genScheme, HttpServletRequest request, HttpServletResponse response, Model model) {
//		SysUser user = UserUtils.getUser();
//		if (!user.isAdmin()){
//			genScheme.setCreateBy(user);
//		}
//        Page<GenScheme> page = genSchemeService.find(new Page<GenScheme>(request, response), genScheme); 
//        model.addAttribute("page", page);
		
		return "modules/gen/genSchemeList";
	}

	@RequestMapping(value = "form")
	public String form(GenScheme genScheme, Model model) {
		if (StringUtils.isBlank(genScheme.getPackageName())){
			genScheme.setPackageName("com.thinkgem.jeesite.modules");
		}
//		if (StringUtils.isBlank(genScheme.getFunctionAuthor())){
//			genScheme.setFunctionAuthor(UserUtils.getUser().getName());
//		}
		model.addAttribute("genScheme", genScheme);
		model.addAttribute("config", GenUtils.getConfig());
		model.addAttribute("tableList", genTableService.findAll());
		return "modules/gen/genSchemeForm";
	}

	@RequestMapping(value = "save")
	public String save(GenScheme genScheme, Model model, RedirectAttributes redirectAttributes) {
//		if (!beanValidator(model, genScheme)){
//			return form(genScheme, model);
//		}
		
		String result = genSchemeService.save(genScheme);
		addMessage(redirectAttributes, "操作生成方案'" + genScheme.getName() + "'成功<br/>"+result);
		return "redirect:" + adminPath + "/gen/genScheme/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(GenScheme genScheme, RedirectAttributes redirectAttributes) {
		genSchemeService.delete(genScheme);
		addMessage(redirectAttributes, "删除生成方案成功");
		return "redirect:" + adminPath + "/gen/genScheme/?repage";
	}

}
