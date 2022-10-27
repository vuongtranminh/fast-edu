package app.command.api.model;

import java.io.Serializable;

public class QuizAnswerRequestModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String quizId;
	private String answer;
	private String explanation;
	private Boolean isCorrect;

	public QuizAnswerRequestModel() { }

	public QuizAnswerRequestModel(String quizId, String answer, String id, String explanation, Boolean isCorrect) {
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

	public static QuizAnswerRequestModelBuilder builder() {
		return new QuizAnswerRequestModelBuilder();
	}
	public static class QuizAnswerRequestModelBuilder {

		private String quizId;
		private String answer;
		private String id;
		private String explanation;
		private Boolean isCorrect;

		public QuizAnswerRequestModelBuilder quizId(String quizId) {
			this.quizId = quizId;
			return this;
		}
		public QuizAnswerRequestModelBuilder answer(String answer) {
			this.answer = answer;
			return this;
		}
		public QuizAnswerRequestModelBuilder id(String id) {
			this.id = id;
			return this;
		}
		public QuizAnswerRequestModelBuilder explanation(String explanation) {
			this.explanation = explanation;
			return this;
		}
		public QuizAnswerRequestModelBuilder isCorrect(Boolean isCorrect) {
			this.isCorrect = isCorrect;
			return this;
		}

		public QuizAnswerRequestModel build() {
			return new QuizAnswerRequestModel(this.quizId, this.answer, this.id, this.explanation, this.isCorrect);
		}

	}
}