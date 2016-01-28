package net.org.myinfo.model;

public class ChangePassword {
	private String oldpassword;

	private String newpassword;
	private String cnfpassword;

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getCnfpassword() {
		return cnfpassword;
	}

	public void setCnfpassword(String cnfpassword) {
		this.cnfpassword = cnfpassword;
	}

}
