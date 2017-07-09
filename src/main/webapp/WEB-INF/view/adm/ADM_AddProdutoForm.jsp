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
	<%@ include file="ADM_Cabecalho.jsp"%>
	<div class="col-lg-3"></div>
	<div class="col-lg-6 spacebottom">
		<form action="/adm/gerenciar_produtos/${path}" method="post" enctype="multipart/form-data">
			<img src="/img/Logos/1_Primary_logo_on_transparent.png"
				class="img-responsive" alt="Logo" />
			<c:if test="${produto != null }">
				<input type="hidden" name="id" value="${produto.id}" />
				<h1 class="center-text">Editar Produto</h1>
			</c:if>
			<c:if test="${produto == null }">
				<h1 class="center-text">Adicionar Produto</h1>
			</c:if>
			<div class="form-group">
				<input type="text" name="nome" placeholder="Nome"
					class="form-control" value="${produto.nome }" required />
			</div>
			<div class="form-group">
				<input type="number" name="qtd" placeholder="QTD"
					class="form-control" value="${produto.qtd }" required />
			</div>
			<div class="form-group">
				<input type="number" class="form-control" placeholder="Preço"
					name="preco" step="0.01" value="${produto.preco }" required />
			</div>
			<div class="form-group">
				<input type="text" name="descricao" placeholder="Descrição"
					class="form-control" value="${produto.descricao}" required />
			</div>
				<label>Imagem do Produto:</label><input type="file" name="file" required />
			<div class="form-group">
				<input type="text" name="classificacao" placeholder="Classificação"
					class="form-control" value="${produto.classificacao}" required />
			</div>
			<button type="submit" class="btn btn-lg btn-primary btn-block">Salvar</button>
		</form>
	</div>
	<div class="col-lg-3"></div>

	<script src="/js/jquery.js"></script>
	<script src="/js/jquery.maskedinput.js"></script>
	<script src="/bootstrap-3.3.7/js/bootstrap.js"></script>
</body>
</html>