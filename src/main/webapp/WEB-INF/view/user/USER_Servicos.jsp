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
	<%@ include file="../Cabecalho.jsp"%>

	<div class="col-lg-12 spacebottom container">
		<div class="col-lg-2"></div>
		<div class="col-lg-8">
			<h1>Gerenciar Serviços Requisitados</h1>
			<table class="table table-hover text-center">
				<thead>
					<tr>
						<th class="text-center">Serviço</th>
						<th class="text-center">Data/Hora</th>
						<th class="text-center">Status</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="agendado" items="${agendados}">
						<tr>
							<td>${agendado.servico.nome}</td>
							<td>${agendado.data}-${agendado.hora}</td>
							<td>${agendado.status}</td>
							<!--Botão Cancelar  -->
								<td>
								<c:if test="${agendado.status == 'ABERTO'}"><a
									href="/usuario/servicos/cancelarServicos/${agendado.id}"
									class="btn btn-danger"> <span
										class="glyphicon glyphicon-remove"></span> Cancelar Serviço
								</a>
							</c:if></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-lg-2"></div>
	</div>
	<script src="/js/jquery.js"></script>
	<script src="/js/jquery.maskedinput.js"></script>
	<script src="/bootstrap-3.3.7/js/bootstrap.js"></script>
</body>
</html>