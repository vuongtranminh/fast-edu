package app.command.api.data.entity;

import java.io.Serializable;

public class AccountPo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String password;
	private String username;

	public AccountPo() { }

	public AccountPo(String password, String id, String username) {
		this.password = password;
		this.id = id;
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
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

	public static AccountPoBuilder builder() {
		return new AccountPoBuilder();
	}
	public static class AccountPoBuilder {

		private String password;
		private String id;
		private String username;

		public AccountPoBuilder password(String password) {
			this.password = password;
			return this;
		}
		public AccountPoBuilder id(String id) {
			this.id = id;
			return this;
		}
		public AccountPoBuilder username(String username) {
			this.username = username;
			return this;
		}

		public AccountPo build() {
			return new AccountPo(this.password, this.id, this.username);
		}

	}
}