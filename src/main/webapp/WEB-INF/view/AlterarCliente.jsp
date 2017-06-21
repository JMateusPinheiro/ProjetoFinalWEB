<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>L11</title>
<link rel="stylesheet" href="/bootstrap-3.3.7/css/bootstrap.css">
</head>
<body>
	<div class="container">
		<h1>Alterar</h1>
		<form action="/clientes/update" method="post">
			<div class="col-lg-8 col-lg-offset-2 ">
				<div class="form-group">
					<label>CPF:</label>${cliente.cpf} <input type="hidden" name="cpf"
						class="form-control" placeholder="CPF" alt="CPF" value="${cliente.cpf}"
						required />
				</div>
				<div class="form-group">
					<input type="text" name="nome" class="form-control"
						placeholder="Nome" alt="Nome" value="${cliente.nome}" required />
				</div>
				<div class="form-group">
					<input type="text" name="endereco" class="form-control"
						placeholder="Endereço" alt="Endereço" value="${cliente.endereco}" required />
				</div>
				<div class="form-group">
					<input type="Number" name="telefone" class="form-control"
						placeholder="Telefone" alt="Telefone" value="${cliente.telefone}" required />
				</div>
				<div class="form-group">
					<input type="email" name="email" class="form-control"
						placeholder="E-mail" alt="E-mail" value="${cliente.email}" required />
				</div>
				<div class="form-group">
					<input type="password" name="senha" class="form-control"
						placeholder="Senha" alt="Senha" value="${cliente.senha}" required />
				</div>
				<div class="form-group">
					<input type="password" name="re-senha" class="form-control"
						placeholder="Digite senha novamente" alt="Digite senha novamente"
						value="${cliente.senha}" required />
				</div>
			</div>
			<div class="col-lg-12">
				<button type="submit" class="btn btn-primary">Alterar</button>
			</div>
		</form>
	</div>
</body>
</html>	