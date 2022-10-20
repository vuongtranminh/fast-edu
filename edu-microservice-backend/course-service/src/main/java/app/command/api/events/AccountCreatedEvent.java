package app.command.api.events;

import java.io.Serializable;

public class AccountCreatedEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String password;
	private String username;

	public AccountCreatedEvent() { }

	public AccountCreatedEvent(String password, String id, String username) {
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

	public static AccountCreatedEventBuilder builder() {
		return new AccountCreatedEventBuilder();
	}
	public static class AccountCreatedEventBuilder {

		private String password;
		private String id;
		private String username;

		public AccountCreatedEventBuilder password(String password) {
			this.password = password;
			return this;
		}
		public AccountCreatedEventBuilder id(String id) {
			this.id = id;
			return this;
		}
		public AccountCreatedEventBuilder username(String username) {
			this.username = username;
			return this;
		}

		public AccountCreatedEvent build() {
			return new AccountCreatedEvent(this.password, this.id, this.username);
		}

	}
}