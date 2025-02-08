package com.finalproject.dto;

public class ExpenseRequest {
    public Integer groupId;
    public Integer payerId;
    public Double amount;
    public String description;

    public ExpenseRequest() {}

    public ExpenseRequest(Integer groupId, Integer payerId, Double amount, String description) {
        this.groupId = groupId;
        this.payerId = payerId;
        this.amount = amount;
        this.description = description;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getPayerId() {
        return payerId;
    }

    public void setPayerId(Integer payerId) {
        this.payerId = payerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
