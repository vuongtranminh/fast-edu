package app.command.api.commands;

import java.io.Serializable;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateAccountCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	@TargetAggregateIdentifier
	private Integer id;
	private String password;
	private String username;

	public UpdateAccountCommand() { }

	public UpdateAccountCommand(String password, Integer id, String username) {
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

	public static UpdateAccountCommandBuilder builder() {
		return new UpdateAccountCommandBuilder();
	}
	public static class UpdateAccountCommandBuilder {

		private String password;
		private Integer id;
		private String username;

		public UpdateAccountCommandBuilder password(String password) {
			this.password = password;
			return this;
		}
		public UpdateAccountCommandBuilder id(Integer id) {
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