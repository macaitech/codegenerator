/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.macaitech.codegenerator.sys.entity;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Lists;
import com.macaitech.common.config.Global;

/**
 * 角色Entity
 * @author ThinkGem
 * @version 2013-12-05
 */
public class SysRole  {
	private Long id;
	private static final long serialVersionUID = 1L;
	private Office office;	// 归属机构
	private String name; 	// 角色名称
	private String enname;	// 英文名称
	private String roleType;// 权限类型
	private String dataScope;// 数据范围
	
	private String oldName; 	// 原角色名称
	private String oldEnname;	// 原英文名称
	private String sysData; 		//是否是系统数据
	private String useable; 		//是否是可用
	
	private SysUser sysUser;		// 根据用户ID查询角色列表

//	private List<SysUser> userList = Lists.newArrayList(); // 拥有用户列表
	private List<SysMenu> menuList = Lists.newArrayList(); // 拥有菜单列表
	private List<Office> officeList = Lists.newArrayList(); // 按明细设置数据范围

	// 数据范围（1：所有数据；2：所在公司及以下数据；3：所在公司数据；4：所在部门及以下数据；5：所在部门数据；8：仅本人数据；9：按明细设置）
	public static final String DATA_SCOPE_ALL = "1";
	public static final String DATA_SCOPE_COMPANY_AND_CHILD = "2";
	public static final String DATA_SCOPE_COMPANY = "3";
	public static final String DATA_SCOPE_OFFICE_AND_CHILD = "4";
	public static final String DATA_SCOPE_OFFICE = "5";
	public static final String DATA_SCOPE_SELF = "8";
	public static final String DATA_SCOPE_CUSTOM = "9";
	
	public SysRole() {
		super();
		this.dataScope = DATA_SCOPE_SELF;
		this.useable=Global.YES;
	}
	
	public SysRole(Long id){
		this.id = id;
	}
	
	public SysRole(SysUser sysUser) {
		this();
		this.sysUser = sysUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUseable() {
		return useable;
	}

	public void setUseable(String useable) {
		this.useable = useable;
	}

	public String getSysData() {
		return sysData;
	}

	public void setSysData(String sysData) {
		this.sysData = sysData;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	@Length(min=1, max=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Length(min=1, max=100)
	public String getEnname() {
		return enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}
	
	@Length(min=1, max=100)
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getDataScope() {
		return dataScope;
	}

	public void setDataScope(String dataScope) {
		this.dataScope = dataScope;
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getOldEnname() {
		return oldEnname;
	}

	public void setOldEnname(String oldEnname) {
		this.oldEnname = oldEnname;
	}

//	public List<SysUser> getUserList() {
//		return userList;
//	}
//
//	public void setUserList(List<SysUser> userList) {
//		this.userList = userList;
//	}
//	
//	public List<String> getUserIdList() {
//		List<String> nameIdList = Lists.newArrayList();
//		for (SysUser sysUser : userList) {
//			nameIdList.add(sysUser.getId());
//		}
//		return nameIdList;
//	}
//
//	public String getUserIds() {
//		return StringUtils.join(getUserIdList(), ",");
//	}

	public List<SysMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<SysMenu> menuList) {
		this.menuList = menuList;
	}

	public List<Long> getMenuIdList() {
		List<Long> menuIdList = Lists.newArrayList();
		for (SysMenu sysMenu : menuList) {
			menuIdList.add(sysMenu.getId());
		}
		return menuIdList;
	}

	public void setMenuIdList(List<String> menuIdList) {
		menuList = Lists.newArrayList();
		for (String menuId : menuIdList) {
			SysMenu sysMenu = new SysMenu();
			sysMenu.setId(Long.valueOf(menuId));
			menuList.add(sysMenu);
		}
	}

	public String getMenuIds() {
		return StringUtils.join(getMenuIdList(), ",");
	}
	
	public void setMenuIds(String menuIds) {
		menuList = Lists.newArrayList();
		if (menuIds != null){
			String[] ids = StringUtils.split(menuIds, ",");
			setMenuIdList(Lists.newArrayList(ids));
		}
	}
	
	public List<Office> getOfficeList() {
		return officeList;
	}

	public void setOfficeList(List<Office> officeList) {
		this.officeList = officeList;
	}

	public List<Long> getOfficeIdList() {
		List<Long> officeIdList = Lists.newArrayList();
		for (Office office : officeList) {
			officeIdList.add(office.getId());
		}
		return officeIdList;
	}

	public void setOfficeIdList(List<String> officeIdList) {
		officeList = Lists.newArrayList();
		for (String officeId : officeIdList) {
			Office office = new Office();
			office.setId(Long.valueOf(officeId));
			officeList.add(office);
		}
	}

	public String getOfficeIds() {
		return StringUtils.join(getOfficeIdList(), ",");
	}
	
	public void setOfficeIds(String officeIds) {
		officeList = Lists.newArrayList();
		if (officeIds != null){
			String[] ids = StringUtils.split(officeIds, ",");
			setOfficeIdList(Lists.newArrayList(ids));
		}
	}
	
	/**
	 * 获取权限字符串列表
	 */
	public List<String> getPermissions() {
		List<String> permissions = Lists.newArrayList();
		for (SysMenu sysMenu : menuList) {
			if (sysMenu.getPermission()!=null && !"".equals(sysMenu.getPermission())){
				permissions.add(sysMenu.getPermission());
			}
		}
		return permissions;
	}

	public SysUser getUser() {
		return sysUser;
	}

	public void setUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

//	public boolean isAdmin(){
//		return isAdmin(this.id);
//	}
//	
//	public static boolean isAdmin(Long id){
//		return id != null && "1".equals(id);
//	}
	
//	@Transient
//	public String getMenuNames() {
//		List<String> menuNameList = Lists.newArrayList();
//		for (SysMenu menu : menuList) {
//			menuNameList.add(menu.getName());
//		}
//		return StringUtils.join(menuNameList, ",");
//	}
}
