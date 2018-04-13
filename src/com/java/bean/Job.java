package com.java.bean;

import java.io.Serializable;

public class Job implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int jobID;
	private String jobName;
	private double jobCategory;
	private String description;
	private String categoryName;
	private String subCategory;
	private String jobCompanyName;

	public Job(int i, String jobName, double jobCategory,
			String description, String string, String subCategory,
			String jobCompanyName) {
		super();
		this.jobID = i;
		this.jobName = jobName;
		this.jobCategory = jobCategory;
		this.description = description;
		this.categoryName = string;
		this.subCategory = subCategory;
		this.jobCompanyName = jobCompanyName;
	}

	public Job() {
	}

	public Job(int i, String productName, double productPrice,
			String description, String string, String productManufacturer) {
		super();
		this.jobID = i;
		this.jobName = productName;
		this.jobCategory = productPrice;
		this.description = description;
		this.categoryName = string;
		this.jobCompanyName = productManufacturer;
	}

	public int getJobID() {
		return jobID;
	}

	public void setJobID(int jobID) {
		this.jobID = jobID;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String productName) {
		this.jobName = jobName;
	}

	public double getProductPrice() {
		return jobCategory;
	}

	public void setProductPrice(double productPrice) {
		this.jobCategory = productPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return categoryName;
	}

	public void setCategory(String category) {
		this.categoryName = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getJobCompanyName() {
		return jobCompanyName;
	}

	public void setJobCompanyName(String productManufacturer) {
		this.jobCompanyName = productManufacturer;
	}

}
