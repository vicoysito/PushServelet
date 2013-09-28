<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery10.2.js"></script>
<script type="text/javascript">

function enviar(){
	
	msj = document.getElementById("Txt_mensaje").value;
	
	$.ajax({
        type: "POST",
        dataType: "text",
        data: {mensaje:msj },
        async: false,
        url: "enviaDatos",
        success: function(data) {
            console.log("su mensaje fue enviado correctamente");
        },
        error: function(data) {
            alert("Algún error ocurrió." + data);
        }
    });
	
	
}


</script>

<link href="css/styles.css" rel="stylesheet">

</head>
<body>
	<div style="" id="header"></div>
	<div style="" id="body">
	<div style="" id="wrappContent">
		<table style="background:white;">
		<tr>
			<td>Mensaje: </td>
			<td><input id="Txt_mensaje"  type="text"/></td>
		</tr>
		<tr>
			<td></td>
			<td ><button onclick="enviar()">Enviar mensaje</button></td>
			
		</tr>
		</table>
	</div>
	
	</div>
	<div id="footer"></div>
</body>
</html>