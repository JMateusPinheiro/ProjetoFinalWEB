<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div id="content" class="col-lg-12">
		<c:if test="${not empty msg && ver == 'Success'}">
			<div class="alert alert-success alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<p>${msg}</p>
			</div>
		</c:if>
		<div class="jumbotron banner container-fluid"></div>
		<div class="container">
			<div>
				<h3>Produtos em Destaque</h3>
			</div>
		</div>
	</div>
</body>
</html>