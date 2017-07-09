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
				<h1>Gerenciar Produtos</h1>
				<a href="/adm/gerenciar_produtos/FormAdd"><button
						class="btn btn-primary">Adicionar Produto</button></a>
				<table class="table table-hover text-center">
					<thead>
						<tr>
							<th class="text-center">Imagem</th>
							<th class="text-center">Nome</th>
							<th class="text-center">Preço</th>
							<th class="text-center">Descrição</th>
							<th class="text-center">Quantidade</th>
							<th class="text-center">Classificação</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="produto" items="${produtos}">
							<tr>
								<td><img src="${produto.img_link}" class="thumbnail limg"></td>
								<td>${produto.nome}</td>
								<td>R$ ${produto.preco}</td>
								<td>${produto.descricao}</td>
								<td>${produto.qtd}</td>
								<td>${produto.classificacao}</td>
								<!--Botão Editar  -->
								<td><a href="/adm/" class="btn btn-warning"><span
										class="glyphicon glyphicon-edit"></span> Editar</a></td>
								<!-- Botão Deletar-->
								<td><a href="/adm/gerenciar_produtos/remove/${produto.id}" class="btn btn-danger"><span
										class="glyphicon glyphicon-trash"></span> Remover</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-lg-1"></div>
	</div>
	<script src="/js/jquery.js"></script>
	<script src="/js/jquery.maskedinput.js"></script>
	<script src="/bootstrap-3.3.7/js/bootstrap.js"></script>
</body>
</html>