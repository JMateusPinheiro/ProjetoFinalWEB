<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div id="form-login" class="form-login col-lg-12">
		<div class="col-md-4"></div>
		<div class="col-md-4 col-lg-4">
			<form method="post" action="logar">
				<img src="/img/Logos/1_Primary_logo_on_transparent.png" class="img-responsive" alt="" />
				<div class="form-group">
					<input type="email" name="email" placeholder="Email"
						class="form-control" required />
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="Password" name="senha"
						required />
				</div>
				<button type="submit" class="btn btn-lg btn-primary btn-block">Entrar</button>

			</form>
		</div>

		<div class="col-md-4"></div>
	</div>
</body>
</html>