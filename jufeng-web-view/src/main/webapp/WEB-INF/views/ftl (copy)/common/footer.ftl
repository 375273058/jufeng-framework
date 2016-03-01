<!-- footer -->
	<div id="footer">
	<h1>get in touch</h1>
	<h3 class="center follow">
	We're social and we'd love to hear from you! Feel free to send us an email, find us on Google Plus, follow us on Twitter and join us on Facebook.</h3>
	
	<div class="follow_us">
		<a href="#" class="zocial twitter"></a>
		<a href="#" class="zocial facebook"></a>
		<a href="#" class="zocial linkedin"></a>
		<a href="#" class="zocial googleplus"></a>
		<a href="#" class="zocial vimeo"></a>
		</div>
	</div>
	
	<!-- footer 2 -->
	<div id="footer2">
		<div class="container">
			<div class="row">
				<div class="span12">
				<div class="copyright">
							FLATI
							&copy;
							<script type="text/javascript">
							//<![CDATA[
								var d = new Date()
								document.write(d.getFullYear())
								//]]>
								</script>
							 - All Rights Reserved :
							More Templates <a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
						</div>
						</div>
					</div>
				</div>
					</div>
						
				<!-- up to top -->
				<a href="#"><i class="go-top hidden-phone hidden-tablet fa fa-angle-double-up"></i></a>
				<!--//end-->
<!-- SCRIPTS -->

<script src="js/bootstrap.min.js"></script>	
<script type="text/javascript" src="js/jquery.themepunch.revolution.min.js"></script>
<script type="text/javascript" src="js/jquery.themepunch.plugins.min.js"></script>
<!-- slider settings -->
<script>
	//<![CDATA[
    $(document).ready(function() {
	if ($.fn.cssOriginal!=undefined)
	$.fn.css = $.fn.cssOriginal;
	$('.fullwidthbanner').revolution(
		{
			delay:9000,
			startwidth:1170,
			startheight:550,
			onHoverStop:"on",	
			navigationType:"none",		
			soloArrowLeftHOffset:0,
			soloArrowLeftVOffset:0,
			soloArrowRightHOffset:0,
			soloArrowRightVOffset:0,
			touchenabled:"on",			
			fullWidth:"on",
			shadow:0					
		});
	});
//]]>
</script>
<script src="js/jquery.touchSwipe.min.js"></script>
<script src="js/jquery.mousewheel.min.js"></script>				
<script type="text/javascript" src="js/jquery.prettyPhoto.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>
<!-- carousel -->
<script type="text/javascript" src="js/jquery.carouFredSel-6.2.1-packed.js"></script>
<script type="text/javascript">
//<![CDATA[
jQuery(document).ready(function($) {
	$("#slider_home").carouFredSel({ width : "100%", height : "auto",
	responsive : true,  circular : true, infinite	: false, auto : false,
	items : { width : 231, visible: { min: 1, max: 3 }
	},
	swipe : { onTouch : true, onMouse : true },
	scroll: { items: 3, },
	prev : { button : "#sl-prev", key : "left"},
	next : { button : "#sl-next", key : "right" }
	});
		});
		//]]>
	</script>
</body>
</html>