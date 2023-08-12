package model;

public class TaskModel {
    private int id;
    private String taskName;
    private String startDate;
    private String endDate;
    private int userId;
    private int jobId;
    private int statusId;

    public int getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getUserId() {
        return userId;
    }

    public int getJobId() {
        return jobId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
}
