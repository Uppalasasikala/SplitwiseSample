package com.finalproject.Entity;

import jakarta.persistence.*;
@Entity
@Table(name = "settlements")
public class Settlement {
    @Id
    @Column(name = "id", nullable = false, unique = true)
	public Integer id;

    @ManyToOne
    @JoinColumn(name = "payer_id", nullable = false)
	public User payer;

    @ManyToOne
    @JoinColumn(name = "payee_id", nullable = false)
	public User payee;

    @Column(name = "amount", nullable = false)
	public Double amount;
    public Settlement() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getPayer() {
		return payer;
	}
	public void setPayer(User payer) {
		this.payer = payer;
	}
	public User getPayee() {
		return payee;
	}
	public void setPayee(User payee) {
		this.payee = payee;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}