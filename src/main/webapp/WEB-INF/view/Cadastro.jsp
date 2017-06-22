<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div id="form-cadastro" class="col-lg-12 spacebottom">
		<div class="col-lg-3"></div>
		<div class="col-lg-6 ">
			<form action="clientes/add" method="post">
				<img src="img/Logo.png" class="img-responsive" alt="" />
				<h1>Cadastrar</h1>
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
				<button id="btn-cadastrar" type="submit" class="btn btn-primary">Cadastrar</button>
			</form>
		</div>
		<div class="col-lg-3"></div>
	</div>


</body>
</html>