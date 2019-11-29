<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Tarjetas</title>
	</head>
	<body>
	<h1>Lista de tarjetas</h1>
	<a href="/tarjetas/add">Agregar</a><br>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>ORIGEN</th>
			<th>DESTINO</th>
			<th>TRANSPORTE</th>
			<th>FECHA</th>
			<th>HORA</th>
			<th>ACCION</th>
		</tr>
		<c:forEach items="${tarjetas}" var="tarjeta">
			<tr>
				
				<td>${tarjeta.getTarjetaId()}</td>
				<td>${tarjeta.getOrigen()}</td>
				<td>${tarjeta.getDestino()}</td>
				<td>${tarjeta.getTransporte()}</td>
				<td>${tarjeta.getFecha()}</td>
				<td>${tarjeta.getHora()}</td>
				<td>
					<a href="/tarjetas/edit/${tarjeta.getTarjetaId()}"> Editar</a><br>
					<a href="/tarjetas/deleteTarjeta/${tarjeta.getTarjetaId()}"> Eliminar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	</body>
</html>
