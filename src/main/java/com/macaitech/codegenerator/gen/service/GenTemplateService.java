package com.macaitech.codegenerator.gen.service;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.macaitech.codegenerator.gen.dao.GenTemplateDao;
import com.macaitech.codegenerator.gen.entity.GenTemplate;


/**
 * 代码模板Service
 * @author ThinkGem
 * @version 2013-10-15
 */
@Service
@Transactional(readOnly = true)
public class GenTemplateService extends BaseService {

	@Autowired
	private GenTemplateDao genTemplateDao;
	
	public GenTemplate get(Long id) {
		return genTemplateDao.get(id);
	}
	
	public Page<GenTemplate> find(Page<GenTemplate> page, GenTemplate genTemplate) {
		//genTemplate.setPage(page);
		//page.setList(genTemplateDao.findList(genTemplate));
		return page;
	}
	
	@Transactional(readOnly = false)
	public void save(GenTemplate genTemplate) {
		if (genTemplate.getContent()!=null){
			genTemplate.setContent(StringEscapeUtils.unescapeHtml4(genTemplate.getContent()));
		}
		if (genTemplate.getId() == null){
			//TODO
			//genTemplate.preInsert();
			genTemplateDao.insert(genTemplate);
		}else{
			//TODO
			//genTemplate.preUpdate();
			genTemplateDao.update(genTemplate);
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(GenTemplate genTemplate) {
		genTemplateDao.delete(genTemplate);
	}
	
}
