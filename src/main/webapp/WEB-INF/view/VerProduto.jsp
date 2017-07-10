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
<link rel="stylesheet" href="/css/jquery-ui.css">
<link rel="stylesheet" href="/css/jquery.timepicker.css">
</head>
<body>
	<%@ include file="Cabecalho.jsp"%>
	<div class="col-lg-10 col-lg-offset-2">
		<h1>${produto.nome}</h1>
		
		<img src="${produto.img_link }" class="thumbnail produto col-lg-3">
		<div class="panel panel-default col-lg-6 col-lg-offset-1">
			<div class="panel-body">
			<h3>R$:${produto.preco }</h3>
			<p>${produto.descricao }</p><br><br><br>
			<c:if test="${usuario.role == 'usuario' }">
			<c:if test="${not empty msg}">
			<div class="alert alert-success alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<p>${msg}</p>
			</div>
		</c:if>
			<a href="/usuario/addFav/${produto.id}"><button class="btn btn-default"><span class="glyphicon glyphicon-heart"></span> Adicionar a Favoritos</button></a>
			<a><button class="btn btn-default"><span class="glyphicon glyphicon-shopping-cart"></span>Adicionar ao Carrinho</button></a>
			</c:if>
			</div>
		</div>
	</div>
	<script src="/js/jquery.js"></script>
	<script src="/js/jquery.maskedinput.js"></script>
	<script src="/bootstrap-3.3.7/js/bootstrap.js"></script>
</body>
</html>