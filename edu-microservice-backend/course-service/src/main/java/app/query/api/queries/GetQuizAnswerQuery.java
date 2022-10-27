package app.query.api.queries;

import java.io.Serializable;

public class GetQuizAnswerQuery implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	public GetQuizAnswerQuery() { }

	public GetQuizAnswerQuery(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

}