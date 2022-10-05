package app.command.api.model;

import java.io.Serializable;

public class AccountRequestModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String password;
	private String username;

	public AccountRequestModel() { }

	public AccountRequestModel(String password, Integer id, String username) {
		this.password = password;
		this.id = id;
		this.username = username;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public static AccountRequestModelBuilder builder() {
		return new AccountRequestModelBuilder();
	}
	public static class AccountRequestModelBuilder {

		private String password;
		private Integer id;
		private String username;

		public AccountRequestModelBuilder password(String password) {
			this.password = password;
			return this;
		}
		public AccountRequestModelBuilder id(Integer id) {
			this.id = id;
			return this;
		}
		public AccountRequestModelBuilder username(String username) {
			this.username = username;
			return this;
		}

		public AccountRequestModel build() {
			return new AccountRequestModel(this.password, this.id, this.username);
		}

	}
}