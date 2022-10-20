package app.command.api.commands;

import java.io.Serializable;

import app.contracts.BaseCommand;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateAccountCommand extends BaseCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	private String password;
	private String username;

	public UpdateAccountCommand(String id) {
		super(id);
	}

	public UpdateAccountCommand(String password, String id, String username) {
		super(id);
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

	public static UpdateAccountCommandBuilder builder() {
		return new UpdateAccountCommandBuilder();
	}
	public static class UpdateAccountCommandBuilder {

		private String password;
		private String id;
		private String username;

		public UpdateAccountCommandBuilder password(String password) {
			this.password = password;
			return this;
		}
		public UpdateAccountCommandBuilder id(String id) {
			this.id = id;
			return this;
		}
		public UpdateAccountCommandBuilder username(String username) {
			this.username = username;
			return this;
		}

		public UpdateAccountCommand build() {
			return new UpdateAccountCommand(this.password, this.id, this.username);
		}

	}
}