<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Ninja Details</title>
	</head>
	<body>
		<div>
			<p>
				<c:out value="${ninja.firstName}"/>
				<c:out value="${ninja.lastName}"/>
			</p>
			<p><c:out value="${ninja.age}"/></p>
			<p><c:out value="${dojo.name}"/></p>
		</div>
	</body>
</html>