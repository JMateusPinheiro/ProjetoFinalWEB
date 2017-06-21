<%@	page language="java"	contentType="text/html;	charset=UTF-8"	
pageEncoding="UTF-8"%>	
<%@	taglib uri="http://java.sun.com/jsp/jstl/core"	prefix="c"	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetShow</title>
<link rel="stylesheet" href="/bootstrap/css/bootstrap.css">
</head>
<body>
<a href="/" class="btn btn-default pull-right">Listar Usuários</a>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Endereço</th>
					<th>CPF</th>
					<th>Telefone</th>
					<th>Email</th>
					<th>Excluir</th>
					<th>Alterar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cliente" items="${clientes}">
					<tr>
						<td>${cliente.nome}</td>
						<td>${cliente.endereco}</td>
						<td>${cliente.cpf}</td>
						<td>${cliente.telefone}</td>
						<td>${cliente.email}</td>
						<!-- Botão Excluir passando o parametro CPF-->
						<td><a href="/clientes/${cliente.cpf}"
							class="btn btn-primary">Excluir</a></td>

						<!-- Botão Alterar Passando o CPF do cliente para uma Logica que redireciona para a pagina
						de Alteração passando os dados do cliente -->
						<td><a href="/alt/${cliente.cpf}" class="btn btn-primary">Alterar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

</body>
</html>