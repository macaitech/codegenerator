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

import com.macaitech.codegenerator.gen.entity.GenTemplate;
import com.macaitech.codegenerator.gen.service.GenTemplateService;
import com.macaitech.common.web.BaseController;

/**
 * 代码模板Controller
 * @author ThinkGem
 * @version 2013-10-15
 */
@Controller
@RequestMapping(value = "/gen/genTemplate")
public class GenTemplateController extends BaseController {

	@Autowired
	private GenTemplateService genTemplateService;
	
	@ModelAttribute
	public GenTemplate get(@RequestParam(required=false) Long id) {
		if (id != null){
			return genTemplateService.get(id);
		}else{
			return new GenTemplate();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(GenTemplate genTemplate, HttpServletRequest request, HttpServletResponse response, Model model) {
//		SysUser user = UserUtils.getUser();
//		if (!user.isAdmin()){
//			genTemplate.setCreateBy(user);
//		}
//        Page<GenTemplate> page = genTemplateService.find(new Page<GenTemplate>(request, response), genTemplate); 
//        model.addAttribute("page", page);
		return "modules/gen/genTemplateList";
	}

	@RequestMapping(value = "form")
	public String form(GenTemplate genTemplate, Model model) {
		model.addAttribute("genTemplate", genTemplate);
		return "modules/gen/genTemplateForm";
	}

	@RequestMapping(value = "save")
	public String save(GenTemplate genTemplate, Model model, RedirectAttributes redirectAttributes) {
//		if (!beanValidator(model, genTemplate)){
//			return form(genTemplate, model);
//		}
		genTemplateService.save(genTemplate);
		//addMessage(redirectAttributes, "保存代码模板'" + genTemplate.getName() + "'成功");
		return "redirect:" + adminPath + "/gen/genTemplate/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(GenTemplate genTemplate, RedirectAttributes redirectAttributes) {
		genTemplateService.delete(genTemplate);
		//addMessage(redirectAttributes, "删除代码模板成功");
		return "redirect:" + adminPath + "/gen/genTemplate/?repage";
	}

}
