package com.java.bean;

public class Category {

	private int categoryid;
	private String jobCategory;

	public Category(int categoryid, String productCategory) {
		super();
		this.categoryid = categoryid;
		this.jobCategory = productCategory;
	}

	public Category() {
	}

	public Category(String productCategory) {
		// TODO Auto-generated constructor stub
		this.jobCategory = productCategory;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

}
