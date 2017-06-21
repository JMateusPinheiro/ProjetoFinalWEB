<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetShow</title>
<link rel="stylesheet" href="/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<%@ include file="cabecalho.jsp"%>
	<div class="container">
		<div id="form-login">
			<div class="col-md-4"></div>
			<div class="col-md-4 col-lg-4">
				<section class="login-form">
					<form method="post" action="#" role="login">
						<img src="/img/Logo.png" class="img-responsive" alt="" /> 
						<input type="email" name="email" placeholder="Email" class="form-control" required/>
						<input type="password" class="form-control" id="password" placeholder="Password" required />

						<button type="submit" name="go"
							class="btn btn-lg btn-primary btn-block">Entrar</button>
						<div>
							<a href="#">Cadastrar-se</a>
						</div>

					</form>
				</section>
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
			<div>
				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="d-block img-fluid" src="img/image1.jpg"
								alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="img/image2.jpg"
								alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="img/image3.jpg"
								alt="Third slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>

			</div>
			<div>
				<div>
					<div class="thumbnail col-lg-4 col-md-6 col-xs-12">
						<img src="img/image1.jpg">
						<h4>Produto 1</h4>
						<p>Descrição do produto 1</p>
					</div>
					<div class="thumbnail col-lg-4 col-md-6 col-xs-12">
						<img src="img/image2.jpg">
						<h4>Produto 2</h4>
						<p>Descrição do produto 2</p>
					</div>
					<div class="thumbnail col-lg-4 col-md-6 col-xs-12">
						<img src="img/image3.jpg">
						<h4>Produto 3</h4>
						<p>Descrição do produto 3</p>
					</div>
				</div>
				<div>
					<div class="thumbnail col-lg-4 col-md-6 col-xs-12">
						<img src="img/image1.jpg">
						<h4>Produto 1</h4>
						<p>Descrição do produto 1</p>
					</div>
					<div class="thumbnail col-lg-4 col-md-6 col-xs-12">
						<img src="img/image2.jpg">
						<h4>Produto 2</h4>
						<p>Descrição do produto 2</p>
					</div>
					<div class="thumbnail col-lg-4 col-md-6 col-xs-12">
						<img src="img/image3.jpg">
						<h4>Produto 3</h4>
						<p>Descrição do produto 3</p>
					</div>
				</div>
				<div>
					<div class="thumbnail col-lg-4 col-md-6 col-xs-12">
						<img src="img/image1.jpg">
						<h4>Produto 1</h4>
						<p>Descrição do produto 1</p>
					</div>
					<div class="thumbnail col-lg-4 col-md-6 col-xs-12">
						<img src="img/image2.jpg">
						<h4>Produto 2</h4>
						<p>Descrição do produto 2</p>
					</div>
					<div class="thumbnail col-lg-4 col-md-6 col-xs-12">
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
