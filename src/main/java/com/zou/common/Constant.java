package com.zou.common;

import java.util.HashSet;
import java.util.Set;

public class Constant {

	/*
	 * 角色
	 */
	public static class RoleType{
		
		public static final String[] SYS_ROLE= {"admin","user"};
	}
	
	/*
	 * 权限
	 */
	public static class Permission{
		
		public static final String[] SYS_PERMISSION={"admin","user"} ;//"{"+"1"+"2"+"}";
		
	}
	
	public static class Test{
		
		public static final Set<String> TestRole() {
			Set<String> roleSet = new HashSet<>();
			roleSet.add("1");
			return roleSet;
		}
		
		
		public static final String SYS_PERMISSION="1" ;//"{"+"1"+"2"+"}";
		
	}
}
