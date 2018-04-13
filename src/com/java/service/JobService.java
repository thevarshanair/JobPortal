package com.java.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.bean.Category;
import com.java.bean.Job;
import com.java.DBA.DBAConnections;

public class JobService {

	private List<Job> jobs = null;
	private List<Category> categories = null;
	private List<String> subCategories = null;
	private String categoryName;

	// Method to get all jobs available
	public List<Job> getAllJobs() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;
		conn = DBAConnections.getConnecton();
		sql = "select * from jobs";
		jobs = new ArrayList<Job>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Job p = new Job(rs.getInt("jobID"),
						rs.getString("jobName"),
						rs.getDouble("jobID"),
						rs.getString("jobSummary"),
						rs.getString("jobCategory"),
						rs.getString("jobSubCategory"),
						rs.getString("jobCompanyName"));
				jobs.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
	

		}

		return jobs;

	}

	// Method to get the required Job Details
	public Job getJobDetails(int jobId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;
		conn = DBAConnections.getConnecton();
		Job p = new Job();
		sql = "select jobName,jobID,jobSummary,jobCategory,jobSubCategory,jobCompanyName from jobs where jobId=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, jobId);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				p.setJobName(rs.getString(1));
				p.setJobID(rs.getInt(2));
				p.setDescription(rs.getString(3));
				p.setCategory(rs.getString(4));
				p.setSubCategory(rs.getString(5));
				p.setJobCompanyName(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}


		}
		return p;
	}

	// Method to get all the available Categories
	public List<Category> getAllCategories() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;
		conn = DBAConnections.getConnecton();
		sql = "select jobCategory from category";
		categories = new ArrayList<Category>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Category c = new Category(rs.getString("jobCategory"));
				categories.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

	
		}
		return categories;
	}

	// Method to get all the available Subcategories under a Category
	public List<String> getSubCategory(Category category) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;
		conn = DBAConnections.getConnecton();
		sql = "SELECT jobSubCategory FROM subcategory s where s.jobCategory = ? ";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getJobCategory());
			rs = ps.executeQuery();
			subCategories = new ArrayList<String>();
			while (rs.next()) {
				subCategories.add(rs.getString("jobSubCategory"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return subCategories;
	}

	// Method to get all the Jobs based on specified SubCategory
	public List<Job> getJobBySubCategory(String subCategory) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;
		conn = DBAConnections.getConnecton();
		sql = "select jobID,jobName,jobPrice,jobSummary,jobCategory,jobCompanyName from jobs where jobSubCategory=?";
		jobs = new ArrayList<Job>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, subCategory);
			rs = ps.executeQuery();
			while (rs.next()) {
				Job p = new Job(rs.getInt(1), rs.getString(2),
						rs.getDouble(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
				jobs.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return jobs;
	}

	// Method to get all the Jobs based on specified SubCategory
	public List<Job> getJobByCategory(String category) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;
		conn = DBAConnections.getConnecton();
		sql = "select jobID,jobName,jobID,jobSummary,jobCategory,jobCompanyName from jobs where jobCategory=?";
		jobs = new ArrayList<Job>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, category);
			rs = ps.executeQuery();
			while (rs.next()) {
				Job p = new Job(rs.getInt(1), rs.getString(2),
						rs.getDouble(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
				jobs.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}
		return jobs;
	}

	// Method to get Job Category
	// based on Sub Category
	public String getCategoryBySubCategory(String subCategory) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;
		conn = DBAConnections.getConnecton();
		sql = "select jobCategory from subcategory where jobSubCategory=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, subCategory);
			rs = ps.executeQuery();
			while (rs.next()) {
				categoryName = rs.getString("jobCategory");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return categoryName;
	}
}
