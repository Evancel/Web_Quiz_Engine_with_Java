package engine.dto;

public class AnswerDTO {
    private int[] answer;

    public AnswerDTO() {
    }

    public AnswerDTO(int[] answer) {
        this.answer = answer;
    }

    public int[] getAnswer() {
        return answer;
    }

    public void setAnswer(int[] answer) {
        this.answer = answer;
    }
}
