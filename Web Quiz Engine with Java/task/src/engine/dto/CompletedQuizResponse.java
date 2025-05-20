package engine.dto;

import java.time.LocalDateTime;

public class CompletedQuizResponse {
    private Integer id;
    private LocalDateTime completedAt;

    public CompletedQuizResponse() {
    }

    public CompletedQuizResponse(Integer id, LocalDateTime completedAt) {
        this.id = id;
        this.completedAt = completedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}
