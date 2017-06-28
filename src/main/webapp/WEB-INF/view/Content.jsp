<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div id="content" class="col-lg-12">
		<c:if test="${not empty msg}">
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
				<div class="col-lg-12">
					<div class="thumbnail produto col-lg-3 col-md-4 col-xs-12">
						<a href="#"><img
							src="/img/Produtos/Ração-Nestlé-Purina-Pro-Plan-Cat-Urinary-para-Gatos-Adultos-com-Cálculos-Urinários.jpg"></a>
						<h4>Ração Nestlé Purina Pro Plan Cat Urinary para Gato</h4>
						<p>R$ 92,90 Nestlé Purina</p>
					</div>
					<div
						class="thumbnail produto col-lg-3 col-md-4 col-xs-12 col-lg-offset-1">
						<img
							src="/img/Produtos/AmericanPets_Brinquedo_Labirinto__Safari_3102916-3_1.jpg">
						<h4>Produto 2</h4>
						<p>Descrição do produto 2</p>
					</div>
					<div
						class="thumbnail produto col-lg-3 col-md-4 col-xs-12 col-lg-offset-1">
						<img
							src="/img/Produtos/Ração-Royal-Canin-Premium-Cat-para-Gatos-Adultos-Castrados.jpg">
						<h4>Produto 3</h4>
						<p>Descrição do produto 3</p>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="thumbnail produto col-lg-3 col-md-4 col-xs-12">
						<img src="/img/Produtos/zootekna_calopsita_agapornis_frente.jpg">
						<h4>Produto 1</h4>
						<p>Descrição do produto 1</p>
					</div>
					<div
						class="thumbnail produto col-lg-3 col-md-4 col-xs-12 col-lg-offset-1">
						<img src="/img/Produtos/7898334815253_1.jpg">
						<h4>Produto 2</h4>
						<p>Descrição do produto 2</p>
					</div>
					<div
						class="thumbnail produto col-lg-3 col-md-4 col-xs-12 col-lg-offset-1">
						<img src="/img/Produtos/9900004723060_5.jpg">
						<h4>Produto 3</h4>
						<p>Descrição do produto 3</p>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="thumbnail produto col-lg-3 col-md-4 col-xs-12">
						<img src="/img/Produtos/70299.jpg">
						<h4>Produto 1</h4>
						<p>Descrição do produto 1</p>
					</div>
					<div
						class="thumbnail produto col-lg-3 col-md-4 col-xs-12 col-lg-offset-1">
						<img src="/img/Produtos/0000000028958_1.jpg">

						<h4>Produto 2</h4>
						<p>Descrição do produto 2</p>
					</div>
					<div
						class="thumbnail produto col-lg-3 col-md-4 col-xs-12 col-lg-offset-1">
						<img
							src="/img/Produtos/Whiskas_Ração_Sachê_Atum_Adultos_3106415-1.jpg">
						<h4>Produto 3</h4>
						<p>Descrição do produto 3</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>