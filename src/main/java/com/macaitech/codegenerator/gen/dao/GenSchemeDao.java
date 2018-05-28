package com.macaitech.codegenerator.gen.dao;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;
import com.macaitech.codegenerator.gen.entity.GenScheme;

/**
 * 生成方案DAO接口
 * @author ThinkGem
 * @version 2013-10-15
 */
@Mapper
public interface GenSchemeDao {
	
	public GenScheme get(Long id);
	
	public Page<GenScheme> find(Page<GenScheme> page);
	
	public void delete(GenScheme genScheme);
	
	public int insert(GenScheme genScheme) ;
	
	public int update(GenScheme genScheme) ;
	
}
