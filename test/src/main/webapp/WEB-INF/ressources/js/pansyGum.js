
function autoHeight() {
	   $('#content').css('min-height', 0);
	   $('#content').css('min-height', (
	     $(document).height() 
	     - $('#header').height() 
	     - $('#gtco-footer').height()
	   ));
}

$(document).ready(function(){
	autoHeight();
	$('.owl-nav').html('');
});

$(window).resize(function() {
    autoHeight();   
});
