package com.example.aldres.lifeisrpg;

import java.util.Date;

/**
 * Created by Aldres on 21.02.18.
 */

public class Task {
    private String title;
    private String description;
    private int expCost;
    private Date startedAt;
    private Date timeToComplete;
    private Date finishedAt;

    public Task(String title, String description, int expCost, Date startedAt, Date timeToComplete, Date finishedAt) {
        this.title = title;
        this.description = description;
        this.expCost = expCost;
        this.startedAt = startedAt;
        this.timeToComplete = timeToComplete;
        this.finishedAt = finishedAt;
    }

    public Task() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExpCost() {
        return expCost;
    }

    public void setExpCost(int expCost) {
        this.expCost = expCost;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Date getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(Date timeToComplete) {
        this.timeToComplete = timeToComplete;
    }

    public Date getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(Date finishedAt) {
        this.finishedAt = finishedAt;
    }
}
