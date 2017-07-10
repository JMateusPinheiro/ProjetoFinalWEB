<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<%@ include file="Cabecalho.jsp"%>
	<div id="form-cadastro" class="col-lg-12 spacebottom">
		<c:if test="${not empty msg}">
			<div class="alert alert-danger alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<p>${msg}</p>
			</div>
		</c:if>
		<div class="col-lg-3"></div>
		<div class="col-lg-6 ">
			<form action="add" method="post">
				<img src="/img/Logos/1_Primary_logo_on_transparent.png"
					class="img-responsive" alt="" />
				<h1>Cadastrar</h1>
				<div class="form-group">
					<input type="text" name="nome" class="form-control"
						placeholder="Nome" alt="Nome" value="${rusuario.nome}" required />
				</div>
				<div class="form-group">
					<input type="text" name="endereco" class="form-control"
						placeholder="Endereço" alt="Endereço" value="${rusuario.endereco}"
						required />
				</div>
				<div class="form-group">
					<input id="cpf" type="text" name="cpf" class="form-control"
						placeholder="CPF" alt="CPF" value="${rusuario.cpf}" required />
				</div>
				<div class="form-group">
					<input type="text" id="telefone" name="telefone"
						class="form-control" placeholder="Telefone" alt="Telefone"
						value="${rusuario.telefone}" required />
				</div>
				<div class="form-group">
					<input type="email" name="email" class="form-control"
						placeholder="E-mail" alt="E-mail" value="${rusuario.email}"
						required />
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
				<button id="btn-cadastrar" type="submit" class="btn btn-primary">Cadastrar</button>
			</form>
		</div>
		<div class="col-lg-3"></div>
	</div>

	<script src="/js/jquery.js"></script>
	<script src="/js/jquery.maskedinput.js"></script>
	<script src="/bootstrap-3.3.7/js/bootstrap.js"></script>
	<script src="/js/globalscript.js"></script>
</body>
</html>