
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Job</title>
</head>
<body>
<form method="post" action="/searchForm/searchJobs">
<table>
<tr>
<td>Job Categories:</td>
<td><input type="text" name="jobname" size="10" /></td>
<td>Job Category:</td>
<td><select name="jobcategories">
<option value="-1">-Select Category-</option>
<option value="Computer Science">Computer Science</option>
<option value="Civil">Civil</option>
<option value="Mechanical">Mechanical</option>
<option value="Pharmacist">Pharmacist</option>
</select></td>
<td><input type="submit" value="Search Jobs" /></td>
</tr>
</table>
</form>
</body>
</html>