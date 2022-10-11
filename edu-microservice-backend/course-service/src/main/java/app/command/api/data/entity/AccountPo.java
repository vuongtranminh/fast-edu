package app.command.api.data.entity;

import java.io.Serializable;

public class AccountPo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String password;
	private String username;

	public AccountPo() { }

	public AccountPo(String password, Integer id, String username) {
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

	public static AccountPoBuilder builder() {
		return new AccountPoBuilder();
	}
	public static class AccountPoBuilder {

		private String password;
		private Integer id;
		private String username;

		public AccountPoBuilder password(String password) {
			this.password = password;
			return this;
		}
		public AccountPoBuilder id(Integer id) {
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