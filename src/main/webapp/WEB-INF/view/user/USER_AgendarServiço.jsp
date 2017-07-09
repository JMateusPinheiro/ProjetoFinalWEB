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
	<div class="col-lg-4"></div>
	<div class="col-lg-4 ">
		<div id="form-dados">
			<form action="/usuario/requisitar_servico" method="post">
				<img src="/img/Logos/1_Primary_logo_on_transparent.png"
					class="img-responsive" alt="" />
				<h1>Solicitar Serviço</h1>
				<input type="hidden" name="usuario_id" value="${usuario.id}" />
				<div class="form-group ">
					<input type="text" name="data" id="datapicker"
						placeholder="DD/MM/AAAA" class="form-control text-center">
				</div>
				<div class="form-group ">
					<input type="text" name="hora" id="timepicker" placeholder="HH:MM"
						class="form-control text-center">
				</div>
				<div class="form-group">
					<fieldset>
					<legend>Serviço</legend>
						<c:forEach var="servico" items="${servicos}">
							<input type="radio" name="servico_id" value="${servico.id}"> ${servico.nome}
					</c:forEach>
					</fieldset>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Solicitar</button>
				</div>
			</form>
		</div>
		<div class="col-lg-4"></div>
	</div>

	<script src="/js/jquery.js"></script>
	<script src="/js/jquery.maskedinput.js"></script>
	<script src="/bootstrap-3.3.7/js/bootstrap.js"></script>
	<script src="/js/jquery-ui.js"></script>
	<script src="/js/jquery.timepicker.js"></script>
	<script src="/js/globalscript.js"></script>

</body>
</html>