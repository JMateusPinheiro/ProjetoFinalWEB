<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div id="content">
		<c:if test="${not empty msg && ver == 'Success'}">
			<div class="alert alert-success alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<p>${msg}</p>
			</div>
		</c:if>
		<div class="col-lg-2"></div>
		<div class="col-lg-8">
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="/img/banner-home_camas-styllus.jpg" class="center-block">
					</div>
					<div class="item">
						<img src="/img/banner-home_inverno.jpg" class="center-block">
					</div>
					<div class="item">
						<img src="/img/banner-home_linha-perpet.jpg" class="center-block">
					</div>
				</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<div class="col-lg-2"></div>
		<div class="col-lg-12">
			<div class="col-lg-2"></div>
			<div class="container col-lg-8 center">
				<div>
					<h3>Todos os Produtos</h3>
				</div>
				<div class="center">
					<c:forEach var="produto" items="${produtos}">
						<div
							class="thumbnail thumbnail-height col-lg-3 col-md-3 col-sm-3 col-xs-3">
							<a href="/produto/${produto.id}"><img
								src="${produto.img_link}"> ${produto.nome}</a>
							<p>R$:${produto.preco}</p>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="col-lg-2"></div>
		</div>
	</div>

</body>
</html>