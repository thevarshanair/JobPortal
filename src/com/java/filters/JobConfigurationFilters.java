package com.java.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.java.bean.Category;
import com.java.service.JobService;

/**
 * Servlet Filter implementation class ProductConfigurationFilter
 */
public class JobConfigurationFilters implements Filter {

	private ServletContext context;

	

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("Configuring Products and Categories");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		 HashMap<String, List<String>> hashMap=new HashMap<String, List<String>>(1);
		 
		 JobService service = new JobService();
		 List<Category> categoryList = service.getAllCategories();
		
		for (Category category : categoryList) {

			hashMap.put(category.getJobCategory(), service.getSubCategory(category));	
		
			this.context.log("Category Names available are:"+category.getJobCategory());
		}

		this.context.setAttribute("categories", hashMap);
//		this.context.setAttribute("subcategory", subCategories);
		

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}
