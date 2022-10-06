package app.query.api.model;

import java.io.Serializable;

public class AccountResponseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String password;
	private String username;

	public AccountResponseModel() { }

	public AccountResponseModel(String password, Integer id, String username) {
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

	public static AccountResponseModelBuilder builder() {
		return new AccountResponseModelBuilder();
	}
	public static class AccountResponseModelBuilder {

		private String password;
		private Integer id;
		private String username;

		public AccountResponseModelBuilder password(String password) {
			this.password = password;
			return this;
		}
		public AccountResponseModelBuilder id(Integer id) {
			this.id = id;
			return this;
		}
		public AccountResponseModelBuilder username(String username) {
			this.username = username;
			return this;
		}

		public AccountResponseModel build() {
			return new AccountResponseModel(this.password, this.id, this.username);
		}

	}
}