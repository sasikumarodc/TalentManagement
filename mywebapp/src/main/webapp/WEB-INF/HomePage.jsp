<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
 </head>
 <style>
     <%@ include file="/css/styleindex.css"%>
</style>
<body>
	<h2>Talent Management System</h2>

	
<form action="" method="POST" >			
<table>	
		<thead>
			<tr>
				<th>Employee Name</th>
				<th>Department</th>
				<th>Remove</th>
			</tr>
		</thead>
	
	<tbody>
		<c:forEach var="listValue" items="${lists}" varStatus="theCount">
			<tr>
				<td>${listValue}</td>
				<td>${departments[theCount.index]}</td>
				<td><a href="/mywebapp/deleteUser/${theCount.index}">Remove</td>
			</tr>
		</c:forEach>
				
	</tbody>
		
</table>
</tr>

</form>
<button class="btn btn-large btn btn-success btn-lg btn-block" ><b>Add Team Member</b></button>
	
</body>
</html>