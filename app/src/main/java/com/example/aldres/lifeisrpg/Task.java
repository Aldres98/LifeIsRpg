package com.example.aldres.lifeisrpg;

import java.util.Date;

/**
 * Created by Aldres on 21.02.18.
 */

public class Task {
    private String title;
    private String description;
    private int expCost;
    private long startedAt;
    private long timeToComplete;
    private long finishedAt;

    public Task(String title, String description, int expCost, long startedAt, long timeToComplete, long finishedAt) {
        this.title = title;
        this.description = description;
        this.expCost = expCost;
        this.startedAt = startedAt;
        this.timeToComplete = timeToComplete;
        this.finishedAt = finishedAt;
    }

    public Task() {
    }

    public Task(String title, String description, int expCost, long startedAt) {
        this.title = title;
        this.description = description;
        this.expCost = expCost;
        this.startedAt = startedAt;
    }

    public Task(String title, String description, int expCost) {
        this.title = title;
        this.description = description;
        this.expCost = expCost;
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

    public long getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(long startedAt) {
        this.startedAt = startedAt;
    }

    public long getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(long timeToComplete) {
        this.timeToComplete = timeToComplete;
    }

    public long getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(long finishedAt) {
        this.finishedAt = finishedAt;
    }
}
