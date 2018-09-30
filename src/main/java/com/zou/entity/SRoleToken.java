package com.zou.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

public class SRoleToken implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * token
	 */
	private  String token;
	
	/*
	 * 用户权限
	 */
	private  List<SPermission> rolePermission;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<SPermission> getRolePermission() {
		return rolePermission;
	}

	public void setRolePermission(List<SPermission> rolePermission) {
		this.rolePermission = rolePermission;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
