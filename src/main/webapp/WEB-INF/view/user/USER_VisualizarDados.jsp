<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<c:if test="${not empty msg && ver == 'Success'}">
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<p>${msg}</p>
		</div>
	</c:if>
	<c:if test="${not empty msg && ver == 'Failed'}">
		<div class="alert alert-danger alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<p>${msg}</p>
		</div>
	</c:if>
	<div class="col-lg-3"></div>
	<div id="area-dados">
		<div class="panel-group col-lg-6">
			<div class="panel panel-default form-login">
				<div class="panel-heading">Dados Cadastrais</div>
				<div class="panel-body">
					<p>Nome: ${usuario.nome}</p>
					<p>Endereço: ${usuario.endereco}</p>
					<p>CPF Cadastrado: ${usuario.cpf}</p>
					<p>Telefone Para Contato: ${usuario.telefone}</p>
					<p>Email: ${usuario.email}</p>
					<button id="btn-edit" class="btn btn-primary">
						<span class="glyphicon glyphicon-edit"></span> Editar Dados
					</button>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-3"></div>
</body>
</html>