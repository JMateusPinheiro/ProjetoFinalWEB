<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetShow</title>
<link rel="stylesheet" href="/bootstrap-3.3.7/css/bootstrap.css" />
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<%@ include file="Cabecalho.jsp"%>
	<div class="container">
		<div id="form-login" class="form-login">
			<div class="col-md-4"></div>
			<div class="col-md-4 col-lg-4">
				<form method="post" action="#" role="login">
					<img src="img/Logo.png" class="img-responsive" alt="" />
					<div class="form-group">
						<input type="email" name="email" placeholder="Email"
							class="form-control" required />
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="Password"
							required />
					</div>
					<button type="submit" class="btn btn-lg btn-primary btn-block">Entrar</button>
					<div>
						<a href="#">Cadastrar-se</a>
					</div>

				</form>
			</div>

			<div class="col-md-4"></div>
		</div>
		<div id="form-cadastro" class="col-lg-12">
			<h1>Cadastrar</h1>
			<form action="clientes/add" method="post">
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
		</div>
		<div id="content">

			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="..." alt="...">
						<div class="carousel-caption">...</div>
					</div>
					<div class="item">
						<img src="..." alt="...">
						<div class="carousel-caption">...</div>
					</div>
					...
				</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>

			<div>
				<div class="col-lg-12">
					<div class="thumbnail col-lg-4 col-md-4 col-xs-12">
						<img src="img/image1.jpg">
						<h4>Produto 1</h4>
						<p>Descrição do produto 1</p>
					</div>
					<div class="thumbnail col-lg-4 col-md-4 col-xs-12">
						<img src="img/image2.jpg">
						<h4>Produto 2</h4>
						<p>Descrição do produto 2</p>
					</div>
					<div class="thumbnail col-lg-4 col-md-4 col-xs-12">
						<img src="img/image3.jpg">
						<h4>Produto 3</h4>
						<p>Descrição do produto 3</p>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="thumbnail col-lg-4 col-md-4 col-xs-12">
						<img src="img/image1.jpg">
						<h4>Produto 1</h4>
						<p>Descrição do produto 1</p>
					</div>
					<div class="thumbnail col-lg-4 col-md-4 col-xs-12">
						<img src="img/image2.jpg">
						<h4>Produto 2</h4>
						<p>Descrição do produto 2</p>
					</div>
					<div class="thumbnail col-lg-4 col-md-4 col-xs-12">
						<img src="img/image3.jpg">
						<h4>Produto 3</h4>
						<p>Descrição do produto 3</p>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="thumbnail col-lg-4 col-md-4 col-xs-12">
						<img src="img/image1.jpg">
						<h4>Produto 1</h4>
						<p>Descrição do produto 1</p>
					</div>
					<div class="thumbnail col-lg-4 col-md-4 col-xs-12">
						<img src="img/image2.jpg">

						<h4>Produto 2</h4>
						<p>Descrição do produto 2</p>
					</div>
					<div class="thumbnail col-lg-4 col-md-4 col-xs-12">
						<img src="img/image3.jpg">
						<h4>Produto 3</h4>
						<p>Descrição do produto 3</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/js/jquery.js"></script>
	<script src="/bootstrap/js/bootstrap.js"></script>
</body>
</html>
