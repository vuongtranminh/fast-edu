package app.command.api.commands;

import java.io.Serializable;

import app.contracts.BaseUpdateCommand;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateQuizAnswerCommand extends BaseUpdateCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	private String quizId;
	private String answer;
	private String explanation;
	private Boolean isCorrect;

	public UpdateQuizAnswerCommand(String id) {
		super(id);
	}

	public UpdateQuizAnswerCommand(String quizId, String answer, String id, String explanation, Boolean isCorrect) {
		super(id);
		this.quizId = quizId;
		this.answer = answer;
		this.explanation = explanation;
		this.isCorrect = isCorrect;
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

	public static UpdateQuizAnswerCommandBuilder builder() {
		return new UpdateQuizAnswerCommandBuilder();
	}
	public static class UpdateQuizAnswerCommandBuilder {

		private String quizId;
		private String answer;
		private String id;
		private String explanation;
		private Boolean isCorrect;

		public UpdateQuizAnswerCommandBuilder quizId(String quizId) {
			this.quizId = quizId;
			return this;
		}
		public UpdateQuizAnswerCommandBuilder answer(String answer) {
			this.answer = answer;
			return this;
		}
		public UpdateQuizAnswerCommandBuilder id(String id) {
			this.id = id;
			return this;
		}
		public UpdateQuizAnswerCommandBuilder explanation(String explanation) {
			this.explanation = explanation;
			return this;
		}
		public UpdateQuizAnswerCommandBuilder isCorrect(Boolean isCorrect) {
			this.isCorrect = isCorrect;
			return this;
		}

		public UpdateQuizAnswerCommand build() {
			return new UpdateQuizAnswerCommand(this.quizId, this.answer, this.id, this.explanation, this.isCorrect);
		}

	}
}