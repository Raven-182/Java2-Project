import java.time.LocalDate;

import javafx.scene.control.Button;

public class Task {

    private String taskDescription;
    private LocalDate date;

    public String getTask() {
        return taskDescription;
    }

    public void setTask(String task) {
        this.taskDescription = task;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Task(String task, LocalDate date) {
        this.taskDescription = task;
        this.date = date;
    }

    public String toString() {

        return date + " Task: " + taskDescription;
    }

}
