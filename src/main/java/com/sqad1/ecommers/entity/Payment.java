package com.sqad1.ecommers.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;

	private Integer userId;
	private Double totalPrice;
	private LocalDate Orderdate;

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getOrderdate() {
		return Orderdate;
	}

	public void setOrderdate(LocalDate orderdate) {
		Orderdate = orderdate;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", userId=" + userId + ", totalPrice=" + totalPrice + ", Orderdate="
				+ Orderdate + ", getPaymentId()=" + getPaymentId() + ", getUserId()=" + getUserId()
				+ ", getTotalPrice()=" + getTotalPrice() + ", getOrderdate()=" + getOrderdate() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
