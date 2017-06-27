<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<header>
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand logo" href="/"><img
						src="/img/Logos/1_Primary_logo_on_transparent_nav.png" /></a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li><a href="/">Início</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Cachorros <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Produtos</a></li>
								<li><a href="#">Serviços</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Gatos <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Produtos</a></li>
								<li><a href="#">Serviços</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Aves <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Produtos</a></li>
								<li><a href="#">Serviços</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Roedores <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Produtos</a></li>
								<li><a href="#">Serviços</a></li>
							</ul></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"><span
								class="glyphicon glyphicon-shopping-cart"></span> Carrinho</a></li>
						<li><a id="btn-cadastro" href="#"><span
								class="glyphicon glyphicon-user"></span> Cadastrar-se</a></li>
						<li><a id="btn-login" href="#"><span
								class="glyphicon glyphicon-log-in"></span> Entrar</a></li>
						<li class="dropdown"><a id="btn-perfil" class="dropdown-toggle"
							data-toggle="dropdown" href="#">${cliente.email}<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#"><span
								class="glyphicon glyphicon-user"></span> Perfil</a></li>
								<li><a href="#"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
</body>
</html>