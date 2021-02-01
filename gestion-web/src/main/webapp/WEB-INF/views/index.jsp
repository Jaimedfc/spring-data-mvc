<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos por categoria</title>
</head>
<body>
	<h2>
		<a href="<c:url value='/'/>">Inicio</a>
	</h2>
	<h1>Productos por categoria</h1>
	<f:form method="get" modelAttribute="categoria">
		<select name="categoria">
			<c:forEach items="${categorias}"
				var="cat">
				<option value="${cat.id}">${cat.nombre}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Buscar productos">
	</f:form>
	
	<ul>
		<c:forEach items="${productos}"
				var="producto">
				<h3>${producto.nombre}</h3>&nbsp;&nbsp;&nbsp;
				<a href="<c:url value='/producto/${producto.id}'/>">Detalles</a>
		</c:forEach>
	</ul>
</body>
</html>