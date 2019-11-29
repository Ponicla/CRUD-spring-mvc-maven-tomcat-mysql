<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Tarjetas</title>
	</head>
	<body>
	<h1>Editar una tarjeta</h1>
	<br>
	<form action="/tarjetas/editTarjeta" method="POST">
		<label>Origen: </label><input type="text" name="origen" id="origen" value="${origen}" /><br>
		<label>Destino: </label><input type="text" name="destino" id="destino" value="${destino}" /><br>
		<label>Transporte: </label><input type="text" name="transporte" id="transporte" value="${transporte}" /><br>
		<label>Fecha: </label><input type="text" name="fecha" id="fecha" value="${fecha}"/><br>
		<label>Hora: </label><input type="text" name="hora" id="hora" value="${hora}" /><br>
		<input type="hidden" name="tarjetaId" id="tarjetaId" value="${tarjetaId}"/>
		<button type="submit">Guardar</button>
	</form>
	
	
	</body>
</html>
