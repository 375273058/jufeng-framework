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
<!-- js -->
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
</head>
<body>
	<!--navigation-->
	<jsp:include  page="top.jsp"/>
	<!--//navigation-->
	<!--banner-->
	<div class="banner about-bnr">
		<div class="container">
			<!--banner-info-->
			<div class="bnr-text">
				<h1><a href="index.html"><span></span>Justice</a></h1>
			</div>
			<div class="bnr-img about-bnr-img">
				<img src="images/1.png" alt=""/>
			</div>	
			<div class="clearfix"> </div>
			<!--//banner-info-->
		</div>
	</div>
	<!--//banner-->
	<!--about-->
	<div class="about">
		<h3 class="title">About Us</h3>
		<div class="container">
			<div class="about-info">
				<div class="col-md-8 about-grids">
					<h4>Blanditiis praesentium deleniti atque corrupti quos </h4>
					<p>Dignissimos at vero eos et accusamus et iusto odio ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecat officia deserunt mollitia laborum et dolorum fuga. At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecat </p>		
					<img src="images/img3.jpg" alt=""/>
				</div>
				<div class="col-md-4 about-grids">
					<h4>Our Principles</h4>
					<div class="pince">
						<div class="pince-left">
							<h5>01</h5>
						</div>
						<div class="pince-right">
							<p>Vero vulputate enim non justo posuere placerat. Phasellus eget purus vel mauris tincidunt tincidunt.</p>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="pince">
						<div class="pince-left">
							<h5>02</h5>
						</div>
						<div class="pince-right">
							<p>Vero vulputate enim non justo posuere placerat. Phasellus eget purus vel mauris tincidunt tincidunt.</p>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="pince">
						<div class="pince-left">
							<h5>03</h5>
						</div>
						<div class="pince-right">
							<p>Vero vulputate enim non justo posuere placerat. Phasellus eget purus vel mauris tincidunt tincidunt.</p>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="pince">
						<div class="pince-left">
							<h5>04</h5>
						</div>
						<div class="pince-right">
							<p>Vero vulputate enim non justo posuere placerat. Phasellus eget purus vel mauris tincidunt tincidunt.</p>
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--//about-->
	<!--skill-->
	<div class="skill">
		<div class="container">
			<div class="col-md-4 skill-grids">
				<h3 class="title">Our Strategy</h3>
			</div>
			<div class="col-md-8 skill-grids">
				<div class="progress">
					<div class="progress-bar" role="progressbar" aria-valuenow="82" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
						<h6>Criminal Law</h6> <p>82%</p>
					</div>
				</div>
				<div class="progress">
					<div class="progress-bar" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">
						<h6>Health Law</h6> <p>80%</p>
					</div>
				</div>
				<div class="progress">
					<div class="progress-bar" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width:90%;">
						<h6>Child Law</h6> <p>90%</p>
					</div>
				</div>
				<div class="progress">
					<div class="progress-bar" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%;">
						<h6>Industrial Law</h6> <p>75%</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--//skill-->
	<!--about-team-->
	<div class="about team">		
		<div class="container">
			<h3 class="title">Our Team</h3>
			<div class="row team-row">
				<div class="col-md-3 team-grids">
					<div class="thumbnail team-thmnl">
						<img src="images/img7.jpg" class="img-responsive zoom-img" alt="...">
						<div class="caption">
							<h4><a href="#">Vaura Tegsner</a></h4>
							<p>Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary</p>						
						</div>
					</div>
				</div>
				<div class="col-md-3 team-grids">
					<div class="thumbnail team-thmnl">
						<img src="images/img8.jpg" class="img-responsive zoom-img" alt="...">
						<div class="caption">
							<h4><a href="#">Jark Kohnson</a></h4>
							<p>Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary</p>						
						</div>
					</div>
				</div>
				<div class="col-md-3 team-grids">
					<div class="thumbnail team-thmnl">
						<img src="images/img9.jpg" class="img-responsive zoom-img" alt="...">
						<div class="caption">
							<h4><a href="#">Goes Mehak</a></h4>
							<p>Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary</p>						
						</div>
					</div>
				</div>
				<div class="col-md-3 team-grids">
					<div class="thumbnail team-thmnl">
						<img src="images/img10.jpg" class="img-responsive zoom-img" alt="...">
						<div class="caption">
							<h4><a href="#">Jark Kohnson</a></h4>
							<p>Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary</p>						
						</div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--//about-team-->
	<!--contact-->
	<div class="contact-text" id="contact" >
		<div class="container">
			<h3 class="title">Get in touch</h3>
			<p>Nam ultrices lacus vitae adipiscing aliquet, metus ipsum imperdiet libero, vitae dignissim sapientristique Donec libero dui scelerisque ac augue id ullamcorper elit diam ac nibh convallis.</p>
			<span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
		</div>
	</div>
	<div class="contact">
		<div class="map">
			<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3144.899142009709!2d23.72354!3d37.979482999999995!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x14a1bd238977fb45%3A0xbdf5a6106a003293!2sFashion+Workshop+by+Vicky+Kaya!5e0!3m2!1sen!2sin!4v1440569426817" allowfullscreen></iframe>
			<div class="map-color">
			</div>
		</div>
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