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
<%@ include file="../Cabecalho.jsp"%>
	<div class="col-lg-3"></div>
	<div id="area-dados">
		<div class="panel-group col-lg-6">
			<div class="panel panel-default form-login">
				<div class="panel-heading">Dados Cadastrais</div>
				<div class="panel-body">
					<p>Nome: ${user.nome}</p>
					<p>Endereço: ${user.endereco}</p>
					<p>CPF Cadastrado: ${user.cpf}</p>
					<p>Telefone Para Contato: ${user.telefone}</p>
					<p>Email: ${user.email}</p>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-3"></div>
	<script src="/js/jquery.js"></script>
	<script src="/js/jquery.maskedinput.js"></script>
	<script src="/bootstrap-3.3.7/js/bootstrap.js"></script>
</body>
</html>