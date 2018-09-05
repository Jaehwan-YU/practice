package com.jaehwan.web.entity;

public class MemberRole {
	
	private String memberId;
	private String roleName;
	private boolean defaultRole;

	public MemberRole() {
		
	}
	
	public MemberRole(String memberId, String roleName, boolean defaultRole) {
		super();
		this.memberId = memberId;
		this.roleName = roleName;
		this.defaultRole = defaultRole;
	}
	
	public boolean getDefaultRole() {
		return defaultRole;
	}
	
	public void setDefaultRole(boolean defaultRole) {
		this.defaultRole = defaultRole;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "MemberRole [memberId=" + memberId + ", roleName=" + roleName + "]";
	}
	
	
}

