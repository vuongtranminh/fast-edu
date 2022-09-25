package app.command.api.data;

import java.io.Serializable;

public class RolePo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private Long id;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}