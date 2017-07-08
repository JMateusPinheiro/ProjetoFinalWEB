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
	<div id="form-login" class="form-login col-lg-12">
		<div class="col-md-4"></div>
		<div class="col-md-4 col-lg-4">
			<c:if test="${not empty msg && ver == 'Failed'}">
				<div class="alert alert-danger alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<p>${msg}</p>
				</div>
			</c:if>
			<form method="post" action="logar">
				<img src="/img/Logos/1_Primary_logo_on_transparent.png"
					class="img-responsive" alt="" />
				<div class="form-group">
					<input type="email" name="email" placeholder="Email"
						class="form-control" required />
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="Password"
						name="senha" required />
				</div>
				<button type="submit" class="btn btn-lg btn-primary btn-block">Entrar</button>
				<br />
				<p>
					Não possui cadastro? Clique <a href="/cadastro">aqui</a>
				</p>
			</form>
		</div>

		<div class="col-md-4"></div>
	</div>
	<script src="/js/jquery.js"></script>
	<script src="/js/jquery.maskedinput.js"></script>
	<script src="/bootstrap-3.3.7/js/bootstrap.js"></script>
</body>
</html>