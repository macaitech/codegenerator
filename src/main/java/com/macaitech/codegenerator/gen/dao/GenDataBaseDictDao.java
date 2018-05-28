package com.macaitech.codegenerator.gen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.macaitech.codegenerator.gen.entity.GenTable;
import com.macaitech.codegenerator.gen.entity.GenTableColumn;


/**
 * 业务表字段DAO接口
 * @author ThinkGem
 * @version 2013-10-15
 */
@Mapper
public interface GenDataBaseDictDao {

	/**
	 * 查询表列表
	 * @param genTable
	 * @return
	 */
	List<GenTable> findTableList(GenTable genTable);

	/**
	 * 获取数据表字段
	 * @param genTable
	 * @return
	 */
	List<GenTableColumn> findTableColumnList(GenTable genTable);
	
	/**
	 * 获取数据表主键
	 * @param genTable
	 * @return
	 */
	List<String> findTablePK(GenTable genTable);
	
}
