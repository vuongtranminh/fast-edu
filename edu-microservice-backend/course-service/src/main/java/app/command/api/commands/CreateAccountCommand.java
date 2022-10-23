package app.command.api.commands;

import app.contracts.BaseCommand;

import java.io.Serializable;

public class CreateAccountCommand extends BaseCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	private String password;
	private String username;

	public CreateAccountCommand() {
		super();
	}

	public CreateAccountCommand(String password, String username) {
		super();
		this.password = password;
		this.username = username;
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

	public static CreateAccountCommandBuilder builder() {
		return new CreateAccountCommandBuilder();
	}
	public static class CreateAccountCommandBuilder {

		private String password;
		private String username;

		public CreateAccountCommandBuilder password(String password) {
			this.password = password;
			return this;
		}

		public CreateAccountCommandBuilder username(String username) {
			this.username = username;
			return this;
		}

		public CreateAccountCommand build() {
			return new CreateAccountCommand(this.password, this.username);
		}

	}
}