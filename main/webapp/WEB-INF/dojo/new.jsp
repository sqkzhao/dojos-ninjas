<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>New Dojo</title>
	</head>
	<body>
		<form:form action="/dojos/new" method="POST" modelAttribute="dojo">
			<p>
				<form:errors path="dojo.*">></form:errors>
			</p>
			<p>
				<form:label path="name"></form:label>
				<form:input path="name"/>
				<form:errors path="name"></form:errors>
			</p>
			<button type="submit">Create</button>
		
		</form:form>
	</body>
</html>