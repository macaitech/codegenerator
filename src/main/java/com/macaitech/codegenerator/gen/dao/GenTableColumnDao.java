package com.macaitech.codegenerator.gen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.macaitech.codegenerator.gen.entity.GenTableColumn;

/**
 * 业务表字段DAO接口
 * @author ThinkGem
 * @version 2013-10-15
 */
@Mapper
public interface GenTableColumnDao{
	
	public void deleteByGenTableId(Long genTableId);
	
	
	public List<GenTableColumn> findList(GenTableColumn genTableColumn);
	
	public int insert(GenTableColumn genTableColumn);
	
	public int update(GenTableColumn genTableColumn);
}
