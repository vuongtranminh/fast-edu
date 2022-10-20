package app.command.api.events;

import java.io.Serializable;

public class AccountUpdatedEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String password;
	private String username;

	public AccountUpdatedEvent() { }

	public AccountUpdatedEvent(String password, String id, String username) {
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

	public static AccountUpdatedEventBuilder builder() {
		return new AccountUpdatedEventBuilder();
	}
	public static class AccountUpdatedEventBuilder {

		private String password;
		private String id;
		private String username;

		public AccountUpdatedEventBuilder password(String password) {
			this.password = password;
			return this;
		}
		public AccountUpdatedEventBuilder id(String id) {
			this.id = id;
			return this;
		}
		public AccountUpdatedEventBuilder username(String username) {
			this.username = username;
			return this;
		}

		public AccountUpdatedEvent build() {
			return new AccountUpdatedEvent(this.password, this.id, this.username);
		}

	}
}