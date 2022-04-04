package in.targetpeak.api.entity.help;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HelpHolder {

	@Id
	Integer UserId;
	String FullName;
	String MobileNo;
	Integer RoleId;
	String HelpMessage;
	String HelpMessageInMarathi;

	public HelpHolder() {
		super();
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}

	public Integer getRoleId() {
		return RoleId;
	}

	public void setRoleId(Integer roleId) {
		RoleId = roleId;
	}

	public String getHelpMessage() {
		return HelpMessage;
	}

	public void setHelpMessage(String helpMessage) {
		HelpMessage = helpMessage;
	}

	public String getHelpMessageInMarathi() {
		return HelpMessageInMarathi;
	}

	public void setHelpMessageInMarathi(String helpMessageInMarathi) {
		HelpMessageInMarathi = helpMessageInMarathi;
	}

	@Override
	public String toString() {
		return "HelpHolder [UserId=" + UserId + ", FullName=" + FullName + ", MobileNo=" + MobileNo + ", RoleId="
				+ RoleId + ", HelpMessage=" + HelpMessage + ", HelpMessageInMarathi=" + HelpMessageInMarathi + "]";
	}

}
