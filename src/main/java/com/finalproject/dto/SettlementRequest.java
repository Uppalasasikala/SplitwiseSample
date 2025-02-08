package com.finalproject.dto;

public class SettlementRequest {
    public Integer payerId;
    public Integer payeeId;
    public Double amount;

    public SettlementRequest() {}

    public SettlementRequest(Integer payerId, Integer payeeId, Double amount) {
        this.payerId = payerId;
        this.payeeId = payeeId;
        this.amount = amount;
    }

    public Integer getPayerId() {
        return payerId;
    }

    public void setPayerId(Integer payerId) {
        this.payerId = payerId;
    }

    public Integer getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(Integer payeeId) {
        this.payeeId = payeeId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


}
