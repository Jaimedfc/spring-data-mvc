<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Producto ${producto.id}</title>
</head>
<body>
	<h2>Producto Nº ${producto.id}</h2>
	<h4>Nombre: ${producto.nombre}</h4>
	<h4>Categoria: ${producto.categoria.nombre}</h4>
	<h4>Unidades: ${producto.unidades}</h4>
	<h4>Precio: ${producto.precio} </h4>
</body>
</html>