package com.umpay.ecommerce.insurance.service.bo;

import java.io.Serializable;

/**
 * @Description: 投保信息实体
 * @ClassName: IssuranceBo
 * @author gaoxiang
 * @date 2016年9月7日 下午6:08:27
 */
public class IssuranceBo implements Serializable {
	
	private static final long serialVersionUID = 1941099238522630786L;
	
	/**
	 * @Fields userName : 发起人
	 */
	private String userName;
	
	/**
	 * @Fields amount : 金额
	 */
	private String amount;
	
	/**
	 * @Fields IssuranceName : 保险名称
	 */
	private String issuranceName;
	
	/**
	 * @Fields issuranceDesc : 用途说明
	 */
	private String issuranceDesc;
	
	/**
	 * @Fields startDate : 开始日期
	 */
	private String startDate;
	
	/**
	 * @Fields endDate : 结束日期
	 */
	private String endDate;
	
	private String status = "S";
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getAmount() {
		return amount;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public String getIssuranceName() {
		return issuranceName;
	}
	
	public void setIssuranceName(String issuranceName) {
		this.issuranceName = issuranceName;
	}
	
	public String getIssuranceDesc() {
		return issuranceDesc;
	}
	
	public void setIssuranceDesc(String issuranceDesc) {
		this.issuranceDesc = issuranceDesc;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "IssuranceBo [userName=" + userName + ", amount=" + amount + ", issuranceName=" + issuranceName + ", issuranceDesc=" + issuranceDesc
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + "]";
	}
}
