$(function() {

	var fieldsetCount = $('#formElem').children().length;
	var current 	= 1;
	var stepsWidth	= 0;
    var widths 		= new Array();
    
	$('#steps .step').each(function(i){
        var $step 		= $(this);
		widths[i]  		= stepsWidth;
        stepsWidth	 	+= $step.width();
    });
	
	$('#steps').width(stepsWidth);
	
	$('#formElem').children(':first').find(':input:first').focus();	

	$('#navigation').show();

    $('#navigation a').bind('click',function(e){
		var $this	= $(this);
		var prev	= current;
		$this.closest('ul').find('li').removeClass('selected');
        $this.parent().addClass('selected');

		current = $this.parent().index() + 1;
        $('#steps').stop().animate({
            marginLeft: '-' + widths[current-1] + 'px'
        },700,function(){
			if(current == fieldsetCount)
				validateSteps();
			else
				validateStep(prev);
			$('#formElem').children(':nth-child('+ parseInt(current) +')').find(':input:first').focus();	
		});
        e.preventDefault();
    });
	

	$('#formElem > fieldset').each(function(){
		var $fieldset = $(this);
		$fieldset.children(':last').find(':input').keydown(function(e){
			if (e.which == 9){
				$('#navigation li:nth-child(' + (parseInt(current)+1) + ') a').click();
	
				$(this).blur();
				e.preventDefault();
			}
		});
	});
});