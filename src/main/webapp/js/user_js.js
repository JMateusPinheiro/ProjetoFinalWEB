/**
 * 
 */
function show(){
	$('#btn-edit').click(function() {
		if($('#area-dados').is(":visible") || $('#form-senha').is(":visible")){
			$('#area-dados').hide(500);
			$('#form-alterar').show(500);
		}
	});
}
$(document).ready(function(){
	$('#form-alterar').hide();
	show();
});