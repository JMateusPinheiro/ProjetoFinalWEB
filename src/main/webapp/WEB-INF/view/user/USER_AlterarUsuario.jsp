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
	<div id="form-alterar" class="col-lg-12 spacebottom">
		<div class="col-lg-3"></div>
		<div class="col-lg-6 ">
			<div id="form-dados">
				<form action="usuario/update" method="post">
					<img src="/img/Logos/1_Primary_logo_on_transparent.png"
						class="img-responsive" alt="" />
					<h1>Dados Atuais</h1>
					<input type="hidden" name="id" value="${usuario.id}" />
					<div class="form-group">
						<input type="text" name="nome" class="form-control"
							placeholder="Nome" alt="Nome" value="${usuario.nome}" required />
					</div>
					<div class="form-group">
						<input type="text" name="endereco" class="form-control"
							placeholder="Endereço" alt="Endereço" value="${usuario.endereco}"
							required />
					</div>
					<div class="form-group">
						<input id="cpf" type="text" name="cpf" class="form-control"
							placeholder="CPF" alt="CPF" value="${usuario.cpf}" required />
					</div>
					<div class="form-group">
						<input type="text" id="telefone" name="telefone"
							class="form-control" placeholder="Telefone" alt="Telefone"
							value="${usuario.telefone}" required />
					</div>
					<div class="form-group">
						<input type="email" name="email" class="form-control"
							placeholder="E-mail" alt="E-mail" value="${usuario.email}"
							required />
					</div>
					<div class="form-group">
						<input type="password" name="senha" class="form-control"
							placeholder="Digite a Senha" alt="Senha"  value="${usuario.senha}" required/>
					</div>
					<div class="form-group">
						<input type="password" name="re-senha" class="form-control"
							placeholder="Digite Novamente a senha" value="${usuario.senha}"
							alt="Digite senha novamente" required/>
					</div>
					<button id="btn-cadastrar" type="submit" class="btn btn-primary">Salvar</button>
				</form>
			</div>

		</div>
		<div class="col-lg-3"></div>
	</div>
</body>
</html>
