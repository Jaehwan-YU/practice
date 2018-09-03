package com.jaehwan.web.entity;

public class MemberRole {
	
	private String memberId;
	private String roleName;
	
	public MemberRole() {
		
	}
	
	public MemberRole(String memberId, String roleName) {
		super();
		this.memberId = memberId;
		this.roleName = roleName;
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

