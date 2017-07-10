<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						<li><a href="/"><span class="glyphicon glyphicon-home"></span>
								Início</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Cachorros <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Produtos</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Gatos <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Produtos</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Aves <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Produtos</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Roedores <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Produtos</a></li>
							</ul></li>
						<c:if test="${usuario.role == 'usuario'}">
							<li><a href="/usuario/solicitar_servico">Solicitar
									Serviço</a></li>
						</c:if>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<c:if test="${usuario.role == 'usuario'}">
							<li><a href="#carrinhoModal" data-toggle="modal"><span
									class="glyphicon glyphicon-shopping-cart"></span> Carrinho</a></li>
						</c:if>
						<c:choose>
							<c:when test="${usuario != null}">
								<li class="dropdown"><a id="btn-perfil"
									class="dropdown-toggle" data-toggle="dropdown" href="#">${usuario.nome}
										<span class="caret"></span>
								</a>
									<ul class="dropdown-menu">
										<li><a href="/usuario"><span
												class="glyphicon glyphicon-user"></span> Perfil</a></li>
										<c:if test="${usuario.role == 'admin'}">
											<li><a href="/adm"><span
													class="glyphicon glyphicon-cog"></span> Gerenciar Site</a></li>
										</c:if>
										<c:if test="${usuario.role == 'usuario'}">
											<li><a href="/usuario/servicos"><span
													class="glyphicon glyphicon-user"></span> Serviços</a></li>
											<li><a href="/usuario/verFav"><span
													class="glyphicon glyphicon-user"></span> Favoritos</a></li>
										</c:if>
										<li role="separator" class="divider"></li>
										<li><a href="/deslogar"><span
												class="glyphicon glyphicon-log-out"></span> Sair</a></li>
									</ul></li>
							</c:when>
							<c:otherwise>
								<li><a id="btn-cadastro" href="/cadastro"><span
										class="glyphicon glyphicon-user"></span> Cadastrar-se</a></li>
								<li><a id="btn-login" href="/login"><span
										class="glyphicon glyphicon-log-in"></span> Entrar</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<!-- Modal do Carrinho -->
	<div class="modal fade" id="carrinhoModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Carrinho Atual</h4>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button type="button" class="btn btn-primary">Comprar</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>