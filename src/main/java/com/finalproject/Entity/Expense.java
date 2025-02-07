package com.finalproject.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @Column(name = "id", nullable = false, unique = true)
	public Integer id;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
	public Group group;

    @ManyToOne
    @JoinColumn(name = "payer_id", nullable = false)
	public User payer;

    @Column(name = "amount", nullable = false)
	public Double amount;

    @Column(name = "description", length = 255)
	public String description;
    public Expense() {}

    // Constructor to initialize all fields
    public Expense(Integer id, Double amount, String description) {
        this.id = id;
        this.amount = amount;
        this.description = description;
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public User getPayer() {
		return payer;
	}
	public void setPayer(User payer) {
		this.payer = payer;
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