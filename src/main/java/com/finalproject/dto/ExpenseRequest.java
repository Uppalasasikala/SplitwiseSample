package com.finalproject.dto;

import java.util.List;

public class ExpenseRequest {
    public Integer groupId;
    public Integer payerId;
    public Double amount;
    public String description;
    public List<Integer> participantIds;

    public ExpenseRequest() {}

    public ExpenseRequest(Integer groupId, Integer payerId, Double amount, String description, List<Integer> participantIds) {
        this.groupId = groupId;
        this.payerId = payerId;
        this.amount = amount;
        this.description = description;
        this.participantIds = participantIds;
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

	public List<Integer> getParticipantIds() {
		return participantIds;
	}

	public void setParticipantIds(List<Integer> participantIds) {
		this.participantIds = participantIds;
	}


   


}
