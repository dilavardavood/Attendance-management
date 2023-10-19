package models.specialModels;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatusCountWithClass {
    private String className;
    private StatusCount statusCount;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public StatusCount getStatusCount() {
        return statusCount;
    }

    public void setStatusCount(StatusCount statusCount) {
        this.statusCount = statusCount;
    }
// Constructors, getters, and setters
}
