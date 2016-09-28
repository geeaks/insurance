package com.umpay.ecommerce.insurance.service.bo;

import java.io.Serializable;

public class PaybackBo implements Serializable {
	
	private static final long serialVersionUID = -3979302572455145610L;

	private String userName;
	
	private String issuranceName;
	
	private String amount;
	
	private String paybackDate;
	
	private String status = "S";
	
	private String remark;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getIssuranceName() {
		return issuranceName;
	}
	
	public void setIssuranceName(String issuranceName) {
		this.issuranceName = issuranceName;
	}
	
	public String getAmount() {
		return amount;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getPaybackDate() {
		return paybackDate;
	}
	
	public void setPaybackDate(String paybackDate) {
		this.paybackDate = paybackDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
