<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>${title}</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Justice Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<!--web-fonts-->
<link href='http://fonts.useso.com/css?family=Open+Sans+Condensed:300,700,300italic' rel='stylesheet' type='text/css'>
<!--//web-fonts-->
<!--js-->
<script src="js/jquery-1.11.1.min.js"></script> 
<!-- //js -->
<!-- start-smoth-scrolling-->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>	
<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
		
		$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
			});
		});
</script>
<!--//end-smoth-scrolling-->
<!--ResponsiveTabs-->
<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			$('#horizontalTab').easyResponsiveTabs({
				type: 'default', //Types: default, vertical, accordion           
				width: 'auto', //auto or any width like 600px
				fit: true   // 100% fit in a container
			});
		});
	</script>
<!--//ResponsiveTabs-->
</head>
<body>
	<jsp:include  page="top.jsp"/>
	<!--banner-->
	<div class="banner">
		<div class="container">
			<!--banner-info-->
			<div class="banner-info">
				<!--banner Slider starts Here-->
				<script src="js/responsiveslides.min.js"></script>
				<script>
					// You can also use "$(window).load(function() {"
					$(function () {
					  // Slideshow 3
					  $("#slider3").responsiveSlides({
						auto: false,
						pager: false,
						nav: true,
						speed: 500,
						namespace: "callbacks",
						before: function () {
						  $('.events').append("<li>before event fired.</li>");
						},
						after: function () {
						  $('.events').append("<li>after event fired.</li>");
						}
					  });
				
					});
				</script>
				<!--//End-slider-script-->
				<div  id="top" class="callbacks_container">
					<ul class="rslides" id="slider3">
						<li>
							<div class="bnr-text">
								<h1><a href="index.do"><span></span>Justice</a></h1>
								<h2>Are you need any assistance for legal help ?</h2>
								<p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecat officia deserunt mollitia laborum et dolorum fuga.</p>								
							</div>
							<div class="bnr-img">
								<img src="images/1.png" alt=""/>
							</div>
							<div class="clearfix"> </div>
						</li>
						<li>
							<div class="bnr-text">
							    <h1><a href="index.do"><span></span>Justice</a></h1>
								<h2>We are for you for any legal help ?</h2>
								<p>Dignissimos at vero eos et accusamus et iusto odio ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecat officia deserunt mollitia laborum et dolorum fuga.</p>								
							</div>
							<div class="bnr-img">
								<img src="images/2.png" alt=""/>
							</div>
							<div class="clearfix"> </div>
						</li>
					</ul>
				</div>				
			</div>			
		</div>
	</div>
	<!--//banner-->
	<!--welcome-->
	<div class="welcome">
		<div class="container">
			<h3 class="title">Welcome</h3>
			<div class="welcome-info">
				<h4>Eligendi optio cumque nihil impedit quo minus id quod </h4>			
				<p>Nam libero tempore cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus omnis optio cumque nihil impedit quo minus id quod maxime placeat facere possimus.Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae </p>			
				<div class="welcome-info">
					<div class="col-md-6 welcome-grids">
						<img src="images/img1.jpg" alt=""/>
					</div>
					<div class="col-md-6 welcome-grids">
						<img src="images/img2.jpg" alt=""/>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>
	<!--//welcome-->
	<!--slid-->
	<div class="slid">
		<div class="container">
			<h3 class="title">Areas of Practice</h3>
			<div class="slid-info">
				<div class="col-md-4 slid-grids">
					<div class="slid-grd">
						<ul>
							<li><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><a href="#">Elder abuse Cases</a></li>
							<li><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><a href="#">Employment Law</a></li>
							<li><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><a href="#">Class action lawsuits </a></li>
							<li><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><a href="#"> Intellectual property </a></li>
							<li><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><a href="#"> Immigration Law </a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-4 slid-grids">
					<div class="slid-grd">
						<ul>
							<li><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><a href="#">Elder abuse Cases</a></li>
							<li><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><a href="#">Employment Law</a></li>
							<li><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><a href="#">Class action lawsuits </a></li>
							<li><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><a href="#"> Intellectual property </a></li>
							<li><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><a href="#"> Immigration Law</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-4 slid-grids">
					<div class="slid-grd">
						<ul>
							<li><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><a href="#">Elder abuse Cases</a></li>
							<li><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><a href="#">Employment Law</a></li>
							<li><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><a href="#">Class action lawsuits </a></li>
							<li><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><a href="#"> Intellectual property </a></li>
							<li><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><a href="#"> Immigration Law</a></li>
						</ul>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--//slid-->
	<!--testimonials-->
	<div class="testimonials">
		<div class="container">
			<h3 class="title">Feedback About us</h3>
			<div class="sap_tabs">	
				<div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
					<ul class="resp-tabs-list">
						<li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span><img src="images/img4.jpg" alt=""/></span></li>
						<li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span><img src="images/img5.jpg" alt=""/></span></li>
						<li class="resp-tab-item" aria-controls="tab_item-2" role="tab"><span><img src="images/img6.jpg" alt=""/></span></li>
						<div class="clear"></div>
					</ul>	
					<div class="resp-tabs-container">
						<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">				
							<div class="view view-first">
								<h5>FILAN FISTEKU</h5>
								<p>Donec libero dui, scelerisque ac augue id, tristique ullamcorper elit. Nam ultrices, lacus vitae adipiscing aliquet, metus ipsum imperdiet libero, vitae dignissim sapien diam ac nibh convallis.</p>
							</div>
						</div>
						<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
							<div class="view view-first">
								<h5>ULLAMCORPER FILAN </h5>
								<p>Scelerisque ac augue id Donec libero dui, tristique ullamcorper elit. Nam ultrices, lacus vitae adipiscing aliquet, metus ipsum imperdiet libero, vitae dignissim sapien diam ac nibh convallis.</p>
							</div>
						</div>
						<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-2">
							<div class="view view-first">
								<h5>SCELERISQUE AUGUE</h5>
								<p>Nam ultrices lacus vitae adipiscing aliquet, metus ipsum imperdiet libero, vitae dignissim sapientristique Donec libero dui, scelerisque ac augue id,  ullamcorper elit,diam ac nibh convallis.</p>
							</div>
						</div>
					</div>	
				</div>	
			</div>		  
		</div>
	</div>	
	<!--//testimonials-->
	<!-- pricing-->
	<div class="pricing">
		<div class="container">
			<h3 class="title">Our Features</h3>
			<div class="pricing-info">
				<div class="col-md-4 pricing-grids">
					<span class="glyphicon glyphicon-book" aria-hidden="true"></span>
					<h4>ANALYSIS</h4>
					<ul>
						<li><a href="#">Lorem ipsum dolor</a></li>
						<li><a href="#">In vitae nisl sodales</a></li>
						<li><a href="#">Vivamus mauris imperdiet</a></li>
						<li><a href="#">Curabitur sed elit quis</a></li>
						<li><a href="#">Lorem ipsum dolor</a></li>
						<li><a href="#">In vitae nisl sodales</a></li>
					</ul>
				</div>
				<div class="col-md-4 pricing-grids">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
					<h4>PRACTICE</h4>
					<ul>
						<li><a href="#">Lorem ipsum dolor</a></li>
						<li><a href="#">In vitae nisl sodales</a></li>
						<li><a href="#">Vivamus mauris imperdiet</a></li>
						<li><a href="#">Curabitur sed elit quis</a></li>
						<li><a href="#">Lorem ipsum dolor</a></li>
						<li><a href="#">In vitae nisl sodales</a></li>
					</ul>
				</div>
				<div class="col-md-4 pricing-grids">
					<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
					<h4>SUCCESS</h4>
					<ul>
						<li><a href="#">Lorem ipsum dolor</a></li>
						<li><a href="#">In vitae nisl sodales</a></li>
						<li><a href="#">Vivamus mauris imperdiet</a></li>
						<li><a href="#">Curabitur sed elit quis</a></li>
						<li><a href="#">Lorem ipsum dolor</a></li>
						<li><a href="#">In vitae nisl sodales</a></li>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!-- pricing-->
	<!-- contact -->
	<div class="contact-text" id="contact" >
		<div class="container">
			<h3 class="title">Get in touch</h3>
			<p>Nam ultrices lacus vitae adipiscing aliquet, metus ipsum imperdiet libero, vitae dignissim sapientristique Donec libero dui scelerisque ac augue id ullamcorper elit diam ac nibh convallis.</p>
			<span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
		</div>
	</div>
	<div class="contact">
		<div class="contact-grids">
			<div class="col-md-4 contact-grid news-ltr">
				<div class="newsletter">
					<h3><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>Newsletter</h3>
				</div>
				<form>
					<input type="text" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="">
					<input type="submit" value="Subscribe" >
				</form>
			</div>
			<div class="col-md-5 contact-grid">
				<form>
					<input type="text" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}" required="">
					<input type="text" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="">
					<textarea type="text"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message...';}" required="">Message...</textarea>
					<input type="submit" value="Submit" >
				</form>
			</div>
			<div class="col-md-3 contact-grid">
				<div class="call">
					<div class="col-xs-2 contact-grdl">
						<span class="glyphicon glyphicon-phone" aria-hidden="true"></span>
					</div>
					<div class="col-xs-10 contact-grdr">
						<ul>
							<li>+3402 890 679</li>
							<li>+5356 890 679</li>
						</ul>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="address">
					<div class="col-xs-2 contact-grdl">
						<span class="glyphicon glyphicon-send" aria-hidden="true"></span>
					</div>
					<div class="col-xs-10 contact-grdr">
						<ul>
							<li>345 Diamond Street,</li>
							<li>Greece.</li>
						</ul>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="mail">
					<div class="col-xs-2 contact-grdl">
						<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
					</div>
					<div class="col-xs-10 contact-grdr">
						<ul>
							<li><a href="mailto:example@mail.com">mail@example.com</a></li>
						</ul>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<!--//contact-->
	<!--footer-->
	<div class="footer">
		<div class="footer-info">
			<div class="container">	
				<div class="icons">	
					<ul>
						<li><a href="#" data-toggle="tooltip" data-placement="top" title="Facebook"><img src="images/i1.png" alt=""/></a></li>
						<li><a href="#" data-toggle="tooltip" data-placement="top" title="Twitter"><img src="images/i2.png" alt=""/> </a></li>
						<li><a href="#" data-toggle="tooltip" data-placement="top" title="Google+"><img src="images/i3.png" alt=""/></a></li>
						<li><a href="#" data-toggle="tooltip" data-placement="top" title="LinkedIn"><img src="images/i4.png" alt=""/> </a></li>
						<li><a href="#" data-toggle="tooltip" data-placement="top" title="Pinterest"><img src="images/i5.png" alt=""/> </a></li>
					</ul>
					<script>$(function () {
					  $('[data-toggle="tooltip"]').tooltip()
					})</script>
				</div>
				<p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>					
			</div>
		</div>
	</div>
	<!--//footer--> 
	<!--smooth-scrolling-of-move-up-->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
			var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
			};
			*/
			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
	<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	<!--//smooth-scrolling-of-move-up-->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.js"></script>
</body>
</html>