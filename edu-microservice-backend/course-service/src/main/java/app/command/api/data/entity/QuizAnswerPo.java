package app.command.api.data.entity;

import java.io.Serializable;

public class QuizAnswerPo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String quizId;
	private String answer;
	private String explanation;
	private Boolean isCorrect;

	public QuizAnswerPo() { }

	public QuizAnswerPo(String quizId, String answer, String id, String explanation, Boolean isCorrect) {
		this.quizId = quizId;
		this.answer = answer;
		this.id = id;
		this.explanation = explanation;
		this.isCorrect = isCorrect;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
	public String getQuizId() {
		return quizId;
	}
	public void setQuizId(String quizId) {
		this.quizId = quizId == null ? null : quizId.trim();
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer == null ? null : answer.trim();
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation == null ? null : explanation.trim();
	}
	public Boolean getIsCorrect() {
		return isCorrect;
	}
	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public static QuizAnswerPoBuilder builder() {
		return new QuizAnswerPoBuilder();
	}
	public static class QuizAnswerPoBuilder {

		private String quizId;
		private String answer;
		private String id;
		private String explanation;
		private Boolean isCorrect;

		public QuizAnswerPoBuilder quizId(String quizId) {
			this.quizId = quizId;
			return this;
		}
		public QuizAnswerPoBuilder answer(String answer) {
			this.answer = answer;
			return this;
		}
		public QuizAnswerPoBuilder id(String id) {
			this.id = id;
			return this;
		}
		public QuizAnswerPoBuilder explanation(String explanation) {
			this.explanation = explanation;
			return this;
		}
		public QuizAnswerPoBuilder isCorrect(Boolean isCorrect) {
			this.isCorrect = isCorrect;
			return this;
		}

		public QuizAnswerPo build() {
			return new QuizAnswerPo(this.quizId, this.answer, this.id, this.explanation, this.isCorrect);
		}

	}
}