package com.macaitech.codegenerator.gen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.macaitech.codegenerator.gen.entity.GenTable;

/**
 * 业务表DAO接口
 * @author ThinkGem
 * @version 2013-10-15
 */
@Mapper
public interface GenTableDao {
	
	public GenTable get(Long id);
	
	public List<GenTable> findList(GenTable parentTable);
	
	public List<GenTable> findAllList(GenTable genTable);
	
	
	public void delete(GenTable genTable);
	
	
	public int insert(GenTable genTable);
	
	
	public int update(GenTable genTable);
	
	
}
