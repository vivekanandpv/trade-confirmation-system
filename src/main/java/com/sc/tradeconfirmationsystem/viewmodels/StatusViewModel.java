package com.sc.tradeconfirmationsystem.viewmodels;

import com.sc.tradeconfirmationsystem.models.Transaction;

import java.time.LocalDateTime;

public class StatusViewModel {
    private int id;
    private String txnRefNo;
    private LocalDateTime createdOn;
    private String previousState;
    private String currentState;
    private String processedBy;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTxnRefNo() {
        return txnRefNo;
    }

    public void setTxnRefNo(String txnRefNo) {
        this.txnRefNo = txnRefNo;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getPreviousState() {
        return previousState;
    }

    public void setPreviousState(String previousState) {
        this.previousState = previousState;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
