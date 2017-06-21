<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>L11</title>
<link rel="stylesheet" href="/bootstrap/css/bootstrap.css">
</head>
<body>
	<div class="container">
		<h1>Cadastrar</h1>
		<form action="clientes" method="post">
			<div class="col-lg-8 col-lg-offset-2 ">
				<div class="form-group">
					<input type="text" name="nome" class="form-control"
						placeholder="Nome" alt="Nome" required />
				</div>
				<div class="form-group">
					<input type="text" name="endereco" class="form-control"
						placeholder="Endereço" alt="Endereço" required />
				</div>
				<div class="form-group">
					<input type="Number" name="cpf" class="form-control"
						placeholder="CPF" alt="CPF" required />
				</div>
				<div class="form-group">
					<input type="Number" name="telefone" class="form-control"
						placeholder="Telefone" alt="Telefone" required />
				</div>
				<div class="form-group">
					<input type="email" name="email" class="form-control"
						placeholder="E-mail" alt="E-mail" required />
				</div>
				<div class="form-group">
					<input type="password" name="senha" class="form-control"
						placeholder="Senha" alt="Senha" required />
				</div>
				<div class="form-group">
					<input type="password" name="re-senha" class="form-control"
						placeholder="Digite senha novamente" alt="Digite senha novamente"
						required />
				</div>
			</div>
			<div class="col-lg-12">
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</div>
		</form>
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
	</div>
</body>
</html>
