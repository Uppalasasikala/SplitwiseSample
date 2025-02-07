package com.finalproject.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "expense_split")
public class ExpenseSplit {
    @Id
    @Column(name = "id", nullable = false, unique = true)
	public Integer id;

    @ManyToOne
    @JoinColumn(name = "expense_id", nullable = false)
	public Expense expense;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
	public User user;

    @Column(name = "share_amount", nullable = false)
	public Double shareAmount;
    public ExpenseSplit() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Expense getExpense() {
		return expense;
	}
	public void setExpense(Expense expense) {
		this.expense = expense;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getShareAmount() {
		return shareAmount;
	}
	public void setShareAmount(Double shareAmount) {
		this.shareAmount = shareAmount;
	} 
}