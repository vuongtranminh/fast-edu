package app.command.api.data;

import java.io.Serializable;
import java.util.Date;
import java.util.Date;
import java.util.Date;

public class UserPo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Byte gender;
	private Date birth;
	private Date createdAt;
	private String avatar;
	private String displayName;
	private String cover;
	private String password;
	private Byte isDeleted;
	private Date updatedAt;
	private String phone;
	private Long roleId;
	private Long id;
	private String email;


	public Byte getGender() {
		return gender;
	}
	public void setGender(Byte gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar == null ? null : avatar.trim();
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName == null ? null : displayName.trim();
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover == null ? null : cover.trim();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}
	public Byte getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

}