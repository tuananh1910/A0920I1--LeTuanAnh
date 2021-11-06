package problem1.model;

import java.time.LocalTime;

public class HistoryActive {
    private LocalTime time;
    private String description;

    public HistoryActive() {
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HistoryActive(LocalTime time, String description) {
        this.time = time;
        this.description = description;
    }
}
