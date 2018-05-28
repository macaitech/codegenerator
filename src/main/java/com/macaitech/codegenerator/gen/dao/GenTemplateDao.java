package com.macaitech.codegenerator.gen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.macaitech.codegenerator.gen.entity.GenTemplate;

/**
 * 代码模板DAO接口
 * @author ThinkGem
 * @version 2013-10-15
 */
@Mapper
public interface GenTemplateDao {
	
	public GenTemplate get(Long id);
	
	public List<GenTemplate> findList(GenTemplate genTemplate);
	
	public void delete(GenTemplate genTemplate);
	
	public int insert(GenTemplate genTemplate);
	
	public int update(GenTemplate genTemplate);
	
}
