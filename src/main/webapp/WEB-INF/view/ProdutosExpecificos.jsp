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
	<div class="col-lg-12">
		<div class="col-lg-2"></div>
		<div class="container col-lg-8 center">
			<div class="center">
			<div><h3>Todos os Produtos</h3>
					</div>
				<c:forEach var="produto" items="${produtos}">
					<div
						class="thumbnail thumbnail-height col-lg-3 col-md-3 col-sm-3 col-xs-3">
						<a href="/produto/${produto.id}"><img
							src="${produto.img_link}"> ${produto.nome}</a>
						<p>R$:${produto.preco}</p>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="col-lg-2"></div>
	</div>
	<script src="/js/jquery.js"></script>
	<script src="/js/jquery.maskedinput.js"></script>
	<script src="/bootstrap-3.3.7/js/bootstrap.js"></script>
	<script src="/js/globalscript.js"></script>
</body>
</html>