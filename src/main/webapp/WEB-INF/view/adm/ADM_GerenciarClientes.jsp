<%@	page language="java" contentType="text/html;	charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetShow</title>
<link rel="icon" type="image/png" href="/img/Logos/favicon.ico"
	sizes="32x32" />
<link rel="stylesheet" href="/bootstrap-3.3.7/css/bootstrap.css" />
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<%@ include file="ADM_Cabecalho.jsp"%>

	<div class="col-lg-12 spacebottom container">
		<div class="col-lg-1"></div>
		<div class="col-lg-10">
			<div>
			<h1>Gerenciar Usuários</h1>
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
						<c:forEach var="usuario" items="${usuarios}">
							<tr>
								<td>${usuario.nome}</td>
								<td>${usuario.endereco}</td>
								<td>${usuario.cpf}</td>
								<td>${usuario.telefone}</td>
								<td>${usuario.email}</td>
								<!-- Botão Excluir passando o parametro CPF-->
								<td><a href="/usuario/delete/${usuario.id}"
									class="btn btn-primary">Excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-lg-1"></div>
	</div>
</body>
</html>