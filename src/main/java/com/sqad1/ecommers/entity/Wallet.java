package com.sqad1.ecommers.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer walletId;

	private Integer payPoint;
	private Integer userId;
	private Integer amount;
	private LocalDate ValidDate;

	public Integer getWalletId() {
		return walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

	public Integer getPayPoint() {
		return payPoint;
	}

	public void setPayPoint(Integer payPoint) {
		this.payPoint = payPoint;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public LocalDate getValidDate() {
		return ValidDate;
	}

	public void setValidDate(LocalDate validDate) {
		ValidDate = validDate;
	}

	@Override
	public String toString() {
		return "Wallet [walletId=" + walletId + ", payPoint=" + payPoint + ", userId=" + userId + ", amount=" + amount
				+ ", ValidDate=" + ValidDate + ", getWalletId()=" + getWalletId() + ", getPayPoint()=" + getPayPoint()
				+ ", getUserId()=" + getUserId() + ", getAmount()=" + getAmount() + ", getValidDate()=" + getValidDate()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
