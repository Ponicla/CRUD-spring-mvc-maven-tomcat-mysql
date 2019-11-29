<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Tarjetas</title>
	</head>
	<body>
	<h1>Agregar una nueva tarjeta</h1>
	<br>
	<form action="/tarjetas/addTarjeta" method="POST">
		<label>Origen: </label><input type="text" name="origen" id="origen" /><br>
		<label>Destino: </label><input type="text" name="destino" id="destino" /><br>
		<label>Transporte: </label><input type="text" name="transporte" id="transporte" /><br>
		<label>Fecha: </label><input type="text" name="fecha" id="fecha" /><br>
		<label>Hora: </label><input type="text" name="hora" id="hora" /><br>
		
		<button type="submit">Agregar</button>
	</form>
	
	
	</body>
</html>
