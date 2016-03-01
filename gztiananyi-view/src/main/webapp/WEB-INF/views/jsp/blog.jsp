<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Blog </title>
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
	<!--blog-->
	<div class="blog">
		<div class="container">
			<div class="blog-grid">
				<div class="col-md-8 blog-left">
					<div class="blog-left-grid">
						<div class="blog-leftl">
							<h4>August <span>15</span></h4>
							<a href="#"><i class="glyphicon glyphicon-tags" aria-hidden="true"></i>10</a>
						</div>
						<div class="blog-leftr">
							<div class="blog-img">
								<a href="single.html"><img src="images/img20.jpg" alt=" " class="img-responsive zoom-img " /></a>
							</div>
							<p>"Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
							sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
							Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
							nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in 
							reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla 
							pariatur</p>
							<ul>
								<li><a href="#"><i class="glyphicon glyphicon-user" aria-hidden="true"></i>Admin</a></li>
								<li><a href="#"><i class="glyphicon glyphicon-tags" aria-hidden="true"></i>0 Tages</a></li>
								<li><a href="#"><i class="glyphicon glyphicon-comment" aria-hidden="true"></i>10 Comments</a></li>
							</ul>
							<div class="more m1">
								<a href="single.html">Learn More</a>
							</div>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="blog-left-grid">
						<div class="blog-leftl">
							<h4>August <span>25</span></h4>
							<a href="#"><i class="glyphicon glyphicon-tags" aria-hidden="true"></i>10</a>
						</div>
						<div class="blog-leftr">
							<div class="blog-img">
								<a href="single.html"><img src="images/img21.jpg" alt=" " class="img-responsive zoom-img " /></a>
							</div>
							<p>"Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
							sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
							Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
							nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in 
							reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla 
							pariatur</p>
							<ul>
								<li><a href="#"><i class="glyphicon glyphicon-user" aria-hidden="true"></i>Admin</a></li>
								<li><a href="#"><i class="glyphicon glyphicon-tags" aria-hidden="true"></i>0 Tages</a></li>
								<li><a href="#"><i class="glyphicon glyphicon-comment" aria-hidden="true"></i>10 Comments</a></li>
							</ul>
							<div class="more m1">
								<a href="single.html">Learn More</a>
							</div>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="blog-left-grid">
						<div class="blog-leftl">
							<h4>August <span>29</span></h4>
							<a href="#"><i class="glyphicon glyphicon-tags" aria-hidden="true"></i>10</a>
						</div>
						<div class="blog-leftr">
							<div class="blog-img">
								<a href="single.html"><img src="images/img22.jpg" alt=" " class="img-responsive zoom-img " /></a>
							</div>
							<p>"Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
							sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
							Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
							nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in 
							reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla 
							pariatur</p>
							<ul>
								<li><a href="#"><i class="glyphicon glyphicon-user" aria-hidden="true"></i>Admin</a></li>
								<li><a href="#"><i class="glyphicon glyphicon-tags" aria-hidden="true"></i>0 Tages</a></li>
								<li><a href="#"><i class="glyphicon glyphicon-comment" aria-hidden="true"></i>10 Comments</a></li>
							</ul>
							<div class="more m1">
								<a href="single.html">Learn More</a>
							</div>
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div class="col-md-4 blog-right">
					<h3>Categories</h3>
					<ul>
						<li><a href="#"><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>Aliquam erat volutpat</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>Integer rutrum ante eu lacus</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>Cum sociis natoque penatibus</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>Mauris fermentum dictum magna</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>Sed laoreet aliquam leo</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>Cum sociis natoque penatibus</a></li>
					</ul>
					<div class="recent">
						<h3>Recent Comments</h3>
						<div class="recent-grids">
							<div class="recent-grid">
								<div class="wom">
									<a href="#"><img src="images/img4.jpg" alt=" " class="img-responsive" /></a>
								</div>
								<div class="wom-right">
									<h4><a href="#">Integer rutrum ante eu</a></h4>
									<p>Mauris fermentum dictum magna. Sed laoreet aliquam leo. 
										Ut tellus dolor, dapibus eget.</p>
								</div>
								<div class="clearfix"> </div>
							</div>
							<div class="recent-grid">
								<div class="wom">
									<a href="#"><img src="images/img5.jpg" alt=" " class="img-responsive" /></a>
								</div>
								<div class="wom-right">
									<h4><a href="#">Integer rutrum ante eu</a></h4>
									<p>Mauris fermentum dictum magna. Sed laoreet aliquam leo. 
										Ut tellus dolor, dapibus eget.</p>
								</div>
								<div class="clearfix"> </div>
							</div>
							<div class="recent-grid">
								<div class="wom">
									<a href="#"><img src="images/img6.jpg" alt=" " class="img-responsive" /></a>
								</div>
								<div class="wom-right">
									<h4><a href="#">Integer rutrum ante eu</a></h4>
									<p>Mauris fermentum dictum magna. Sed laoreet aliquam leo. 
										Ut tellus dolor, dapibus eget.</p>
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
					</div>
					<div class="footer-top-grid1">
						<h3>Recent Tags</h3>
						<ul class="tag2">
							<li><a href="#">awesome</a></li>
							<li><a href="#">strategy</a></li>
							<li><a href="#">development</a></li>
						</ul>
						<ul class="tag2">
							<li><a href="#">css</a></li>
							<li><a href="#">photoshop</a></li>
							<li><a href="#">photography</a></li>
							<li><a href="#">html</a></li>
						</ul>
						<ul class="tag2">
							<li><a href="#">awesome</a></li>
							<li><a href="#">strategy</a></li>
							<li><a href="#">development</a></li>
						</ul>
						<ul class="tag2">
							<li><a href="#">css</a></li>
							<li><a href="#">photoshop</a></li>
							<li><a href="#">photography</a></li>
							<li><a href="#">html</a></li>
						</ul>
						<ul class="tag2">
							<li><a href="#">awesome</a></li>
							<li><a href="#">strategy</a></li>
							<li><a href="#">development</a></li>
						</ul>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!-- //news -->
	<!-- contact -->
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