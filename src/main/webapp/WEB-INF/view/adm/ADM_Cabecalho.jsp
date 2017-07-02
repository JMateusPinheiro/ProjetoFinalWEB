<!DOCTYPE html>
<html>
<head>
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
						<li><a href="/adm/gerenciar_usuario"><span class="glyphicon glyphicon-cog"></span>
								Gerenciar Usuários</a></li>
						<li><a href="/adm/gerenciar_produtos"><span class="glyphicon glyphicon-cog"></span>
								Gerenciar Produtos</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-cog"></span>
								Gerenciar Serviços</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a id="btn-perfil"
							class="dropdown-toggle" data-toggle="dropdown" href="#">${usuario.nome} <span
								class="caret"></span></a>
							<ul class="dropdown-menu">
							<li><a href="#"><span class="glyphicon glyphicon-user"></span>
										Perfil</a></li>
								<li><a href="/adm"><span class="glyphicon glyphicon-cog"></span>
										Gerenciar Site</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="/deslogar"><span
										class="glyphicon glyphicon-log-out"></span> Sair</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
</body>
</html>