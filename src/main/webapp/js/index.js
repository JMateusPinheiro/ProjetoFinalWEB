/**
 * 
 */
function show(){
	$('#btn-login').click(function() {
		if($('#content').is(":visible") || $('#form-cadastro').is(":visible")){
			$('#content').hide(500);
			$('#form-cadastro').hide(500);
			$('#btn-login').hide();
			$('#form-login').show(500);
			if($('#btn-cadastro').is(":hidden")){
				$('#btn-cadastro').show();
			}
		}
	});
	$('#btn-cadastro').click(function() {
		if($('#content').is(":visible") || $('#form-login').is(":visible")){
			$('#content').hide(500);
			$('#form-login').hide(500);
			$('#btn-cadastro').hide();
			$('#form-cadastro').show(500);
			if($('#btn-login').is(":hidden")){
				$('#btn-login').show();
			}
		}
	});
//	$('#btn-cadastrar').click(function() {
//		if($('#content').is(":visible") || $('#form-cadastro').is(":visible")){
//			$('#content').hide(500);
//			$('#form-cadastro').hide(500);
//			$('#btn-login').hide();
//			$('#form-login').show(500);
//			if($('#btn-cadastro').is(":hidden")){
//				$('#btn-cadastro').show();
//			}
//		}
//	});
}
$(document).ready(function(){
	$('#form-cadastro').hide();
	$('#form-login').hide();
	show();
});
