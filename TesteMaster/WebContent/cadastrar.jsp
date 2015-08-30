<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cadastrar Contato</title>
	</head>
	<body>
		<form action="/TesteMaster/cadastrarContato" method="POST">
			<br>
			<table>
				<tr>
					<td>Nome: </td>
					<td><input type="text" name="nome" /> <br><br></td>
				</tr>
				<tr>
					<td>E-mail: </td>
					<td><input type="text" name="email" /> <br><br></td>
				</tr>
				<tr>
					<td>Endereço: </td>
					<td><input type="text" name="endereco" /> <br><br></td>
				</tr>
				<tr>
				</tr>
			</table>
			<input type="submit" value="Enviar"/>
		</form>
	</body>
</html>