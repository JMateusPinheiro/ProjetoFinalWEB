/**
 * 
 */
$(function(){
	$("#cpf").mask("999.999.999-99",{placeholder:" "});
	$("#telefone").mask("(99)99999-9999",{placeholder:" "});
	$("#datapicker").mask("99/99/9999",{placeholder:" "})
	$("#timepicker").mask("99:99 aa", {placeholder:" "})
	$("#datapicker").datepicker();
	$("#timepicker").timepicker({
		timeFormat: 'hh:mm p',
		interval: 60,
		minTime: '9',
		maxTime: '5:00pm',
		startTime: '9:00',
		dynamic: true,
		dropdown: true,
		scrollbar: true
	});
})