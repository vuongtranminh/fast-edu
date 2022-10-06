package app.command.api.events;

import java.io.Serializable;

public class AccountDeletedEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	public AccountDeletedEvent() { }

	public AccountDeletedEvent(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}