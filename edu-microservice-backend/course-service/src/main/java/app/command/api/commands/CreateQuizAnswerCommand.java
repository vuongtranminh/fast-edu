package app.command.api.commands;

import java.io.Serializable;

import app.contracts.BaseCommand;
import app.contracts.BaseCreateCommand;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateQuizAnswerCommand extends BaseCreateCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	private String quizId;
	private String answer;
	private String explanation;
	private Boolean isCorrect;

	public CreateQuizAnswerCommand() {
		super();
	}

	public CreateQuizAnswerCommand(String quizId, String answer, String explanation, Boolean isCorrect) {
		super();
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

	public static CreateQuizAnswerCommandBuilder builder() {
		return new CreateQuizAnswerCommandBuilder();
	}
	public static class CreateQuizAnswerCommandBuilder {

		private String quizId;
		private String answer;
		private String explanation;
		private Boolean isCorrect;

		public CreateQuizAnswerCommandBuilder quizId(String quizId) {
			this.quizId = quizId;
			return this;
		}
		public CreateQuizAnswerCommandBuilder answer(String answer) {
			this.answer = answer;
			return this;
		}
		public CreateQuizAnswerCommandBuilder explanation(String explanation) {
			this.explanation = explanation;
			return this;
		}
		public CreateQuizAnswerCommandBuilder isCorrect(Boolean isCorrect) {
			this.isCorrect = isCorrect;
			return this;
		}

		public CreateQuizAnswerCommand build() {
			return new CreateQuizAnswerCommand(this.quizId, this.answer, this.explanation, this.isCorrect);
		}

	}
}