<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>New Ninja</title>
	</head>
	<body>
		<form:form action="/ninjas/new" method="POST" modelAttribute="ninja">
			<p>
				<form:errors path="ninja.*">Dojo</form:errors>
			</p>
			<p>
				<form:label path="dojo">Dojo</form:label>
				<form:select path="dojo">
					<c:forEach items="${allDojos}" var="dojo">
						<form:option value="${dojo.id}">
							<c:out value="${dojo.name}"/>
						</form:option>
					</c:forEach>
				</form:select>
				<form:errors path="dojo"></form:errors>
			</p>
			<p>
				<form:label path="firstName">First Name</form:label>
				<form:input path="firstName"/>
				<form:errors path="firstName"></form:errors>
			</p>
			<p>
				<form:label path="lastName">Last Name</form:label>
				<form:input path="lastName"/>
				<form:errors path="lastName"></form:errors>
			</p>
			<p>
				<form:label path="age">Age</form:label>
				<form:input path="age"/>
				<form:errors path="age"></form:errors>
			</p>
			<button type="submit">Create</button>
		
		</form:form>
	</body>
</html>