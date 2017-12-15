
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ENSAK Deals</title>
<!--/tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--//tags -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/font-awesome.css" rel="stylesheet"> 
<link href="css/easy-responsive-tabs.css" rel='stylesheet' type='text/css'/>
<!-- //for bootstrap working -->
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800" rel="stylesheet">
<link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic' rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>

<jsp:include page="header.jsp" />	


<!--/single_page-->
       <!-- /banner_bottom_agile_info -->
<div class="page-head_agile_info_w3l">
		<div class="container">
			<h3>DEal <span>details </span></h3>
			<!--/w3_short-->
				 <div class="services-breadcrumb">
						<div class="agile_inner_breadcrumb">

						   <ul class="w3_short">
								<li><a href="index.html">Home</a><i>|</i></li>
								<li>Deal page</li>
							</ul>
						 </div>
				</div>
	   <!--//w3_short-->
	</div>
</div>

  <!-- banner-bootom-w3-agileits -->
<div class="banner-bootom-w3-agileits">
	<div class="container">
	     <div class="col-md-4 single-right-left ">
			<div class="grid images_3_of_2">
				<div class="flexslider">
					
					<ul class="slides">
						<li data-thumb="images/d2.jpg">
							<div class="thumb-image"> <img src="<%=request.getContextPath()%>/uploadedImages/${sujetDetails[7]}" data-imagezoom="true" class="img-responsive"> </div>
						</li>
						<!--<li data-thumb="images/d1.jpg">
							<div class="thumb-image"> <img src="images/d1.jpg" data-imagezoom="true" class="img-responsive"> </div>
						</li>	
						<li data-thumb="images/d3.jpg">
							<div class="thumb-image"> <img src="images/d3.jpg" data-imagezoom="true" class="img-responsive"> </div>
						</li>-->
					</ul>
					<div class="clearfix"></div>
				</div>	
			</div>
		</div>
		
		<div id="deleteDeal" class="manageD">
			<s:form action="/deleteDeal.action" validate="false" method="post">
				<fieldset>
					<input type="hidden" name="id_sujet" value="${sujetDetails[0]}">
					<input type="hidden" name="description" value="${sujetDetails[1]}">
					<input type="hidden" name="date_end" value="${sujetDetails[2]}">
					<input type="hidden" name="etat" value="${sujetDetails[3]}">
					<input type="hidden" name="id_vendeur" value="${sujetDetails[5]}">
					<input type="hidden" name="id_rubrique" value="${sujetDetails[6]}">
					<input type="hidden" name="image" value="${sujetDetails[7]}">
					<input type="hidden" name="prix" value="${sujetDetails[8]}">
					<input type="hidden" name="nbr_adherents" value="${sujetDetails[10]}">
					<input type="hidden" name="id_user" value="${currentSessionUserId}">
					<input type="submit" name="submit" value="Delete" class="button">
				</fieldset>
			</s:form>	
		</div>
		
		<div id="requestPayment" class="manageD">
			<s:form action="/requestPayment.action" validate="false" method="post">
				<fieldset>
					<input type="hidden" name="id_sujet" value="${sujetDetails[0]}">
					<input type="hidden" name="description" value="${sujetDetails[1]}">
					<input type="hidden" name="date_end" value="${sujetDetails[2]}">
					<input type="hidden" name="etat" value="${sujetDetails[3]}">
					<input type="hidden" name="id_vendeur" value="${sujetDetails[5]}">
					<input type="hidden" name="id_rubrique" value="${sujetDetails[6]}">
					<input type="hidden" name="image" value="${sujetDetails[7]}">
					<input type="hidden" name="prix" value="${sujetDetails[8]}">
					<input type="hidden" name="nbr_adherents" value="${sujetDetails[10]}">
					<input type="hidden" name="id_user" value="${currentSessionUserId}">
					<input type="submit" name="submit" value="Request payment" class="button">
				</fieldset>
			</s:form>	
		</div>
		
		
		
		
		<div class="col-md-8 single-right-left simpleCart_shelfItem">
			<c:if test="${not empty messageSubs }" var="maVariable">
				<div class="alert alert-success">
			  		<strong>Success!</strong>  ${messageSubs}
				</div>
			</c:if>
					<h3>${sujetDetails[12]} </h3>
					
					<c:choose>
					  <c:when test="${empty sujetDetails[10] or sujetDetails[10] == '0'}">
					    <p><span class="item_price">${sujetDetails[9]} DH</span> </p>
					  </c:when>

					  <c:otherwise>
					     <p><span class="item_price">${sujetDetails[9]} DH</span> 
						<del>- ${sujetDetails[8]} DH </del>
					    </p>
					  </c:otherwise>
					</c:choose>

					
					<div class="occasion-cart">
						<div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
															<s:form action="/editDeal.action" validate="false" method="post">
																<fieldset>
																	<input type="hidden" name="id_sujet" value="${sujetDetails[0]}">
																	<input type="hidden" name="description" value="${sujetDetails[1]}">
																	<input type="hidden" name="date_end" value="${sujetDetails[2]}">
																	<input type="hidden" name="etat" value="${sujetDetails[3]}">
																	<input type="hidden" name="id_vendeur" value="${sujetDetails[5]}">
																	<input type="hidden" name="id_rubrique" value="${sujetDetails[6]}">
																	<input type="hidden" name="image" value="${sujetDetails[7]}">
																	<input type="hidden" name="prix" value="${sujetDetails[8]}">
																	<input type="hidden" name="nbr_adherents" value="${sujetDetails[10]}">
																	<input type="hidden" name="id_user" value="${currentSessionUserId}">
																	<input type="submit" name="submit" value="Edit" class="button">
																</fieldset>
															</s:form>
														</div>
																			
					</div>
					
					<ul class="social-nav model-3d-0 footer-social w3_agile_social single_page_w3ls">
						                                   <div class="product-new-top-left">  ${sujetDetails[10]}<i class="material-icons move-bottom">person_add</i></div>
						                                  <br/> <li class="share">Share On : </li>
															<li><a href="#" class="facebook">
																  <div class="front"><i class="fa fa-facebook" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-facebook" aria-hidden="true"></i></div></a></li>
															<li><a href="#" class="twitter"> 
																  <div class="front"><i class="fa fa-twitter" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-twitter" aria-hidden="true"></i></div></a></li>
															<li><a href="#" class="instagram">
																  <div class="front"><i class="fa fa-instagram" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-instagram" aria-hidden="true"></i></div></a></li>
															<li><a href="#" class="pinterest">
																  <div class="front"><i class="fa fa-linkedin" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-linkedin" aria-hidden="true"></i></div></a></li>
														</ul>
					
		      </div>
	 			<div class="clearfix"> </div>
				<!-- /new_arrivals --> 
	<div class="responsive_tabs_agileits"> 
				<div id="horizontalTab">
						<ul class="resp-tabs-list">
							<li>Description</li>
							<li>Commentaires</li>
							<!--<li>Information</li>-->
						</ul>
					<div class="resp-tabs-container">
					<!--/tab_one-->
					   <div class="tab1">

							<div class="single_page_agile_its_w3ls">
							  <h6>${sujetDetails[12]}</h6>
							   <p>${sujetDetails[1]}</p>
							   <!-- <p class="w3ls_para">Lorem ipsum dolor sit amet, consectetur adipisicing elPellentesque vehicula augue eget nisl ullamcorper, molestie blandit ipsum auctor. Mauris volutpat augue dolor.Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut lab ore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco. labore et dolore magna aliqua.</p> -->
							</div>
						</div>
						<!--//tab_one-->
						<div class="tab2">
							
							<div class="single_page_agile_its_w3ls">
								<div class="bootstrap-tab-text-grids">
									<div class="bootstrap-tab-text-grid">
										<div class="bootstrap-tab-text-grid-left">
											<img src="images/t1.jpg" alt=" " class="img-responsive">
										</div>
										<div class="bootstrap-tab-text-grid-right">
											<ul>
												<li><a href="#">Admin</a></li>
												<li><a href="#"><i class="fa fa-reply-all" aria-hidden="true"></i> Reply</a></li>
											</ul>
											<p>Lorem ipsum dolor sit amet, consectetur adipisicing elPellentesque vehicula augue eget.Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis 
												suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem 
												vel eum iure reprehenderit.</p>
										</div>
										<div class="clearfix"> </div>
						             </div>
									 <div class="add-review">
										<h4>add a review</h4>
										<form action="#" method="post">
												<!--input type="text" name="Name" required="Name" >
												<input type="email" name="Email" required="Email"> -->
												<textarea name="Message" required=""></textarea>
											<input type="submit" value="COMMENTER">
										</form>
									</div>
								 </div>
								 
							 </div>
						 </div>
						 <!--  <div class="tab3">

							<div class="single_page_agile_its_w3ls">
							  <h6>Big Wing Sneakers (Navy)</h6>
							   <p>Lorem ipsum dolor sit amet, consectetur adipisicing elPellentesque vehicula augue eget nisl ullamcorper, molestie blandit ipsum auctor. Mauris volutpat augue dolor.Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut lab ore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco. labore et dolore magna aliqua.</p>
							   <p class="w3ls_para">Lorem ipsum dolor sit amet, consectetur adipisicing elPellentesque vehicula augue eget nisl ullamcorper, molestie blandit ipsum auctor. Mauris volutpat augue dolor.Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut lab ore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco. labore et dolore magna aliqua.</p>
							</div>
						</div>
					</div>
				</div>	
			</div>
	<!-- //new_arrivals --> 
	  	<!--/slider_owl-->
	
			<div class="w3_agile_latest_arrivals">
			<h3 class="wthree_text_info">Similar <span>Deals</span></h3>	
			
					  <div class="col-md-3 product-men single">
								<div class="men-pro-item simpleCart_shelfItem">
									<div class="men-thumb-item">
										<img src="images/w2.jpg" alt="" class="pro-image-front">
										<img src="images/w2.jpg" alt="" class="pro-image-back">
											<div class="men-cart-pro">
												<div class="inner-men-cart-pro">
													<a href="single.html" class="link-product-add-cart">Quick View</a>
												</div>
											</div>
											<span class="product-new-top">New</span>
											
									</div>
									<div class="item-info-product ">
										<h4><a href="single.html">Sleeveless Solid Blue Top</a></h4>
										<div class="info-product-price">
											<span class="item_price">$140.99</span>
											<c:if test="${not empty sujet[10] or sujet[10] ne 0}" var="maVariable">
												<del>${sujet[8]}</del>
											</c:if>
										</div>
										<div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
															<form action="#" method="post">
																<fieldset>
																	<input type="hidden" name="cmd" value="_cart">
																	<input type="hidden" name="add" value="1">
																	<input type="hidden" name="business" value=" ">
																	<input type="hidden" name="item_name" value="Sleeveless Solid Blue Top">
																	<input type="hidden" name="amount" value="30.99">
																	<input type="hidden" name="discount_amount" value="1.00">
																	<input type="hidden" name="currency_code" value="USD">
																	<input type="hidden" name="return" value=" ">
																	<input type="hidden" name="cancel_return" value=" ">
																	<input type="submit" name="submit" value="Add to cart" class="button">
																</fieldset>
															</form>
														</div>
																			
									</div>
								</div>
							</div>
                       <div class="col-md-3 product-men single">
								<div class="men-pro-item simpleCart_shelfItem">
									<div class="men-thumb-item">
										<img src="images/w4.jpg" alt="" class="pro-image-front">
										<img src="images/w4.jpg" alt="" class="pro-image-back">
											<div class="men-cart-pro">
												<div class="inner-men-cart-pro">
													<a href="single.html" class="link-product-add-cart">Quick View</a>
												</div>
											</div>
											<span class="product-new-top">New</span>
											
									</div>
									<div class="item-info-product ">
										<h4><a href="single.html">Black Basic Shorts</a></h4>
										<div class="info-product-price">
											<span class="item_price">$120.99</span>
											<del>$189.71</del>
										</div>
										<div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
															<form action="#" method="post">
																<fieldset>
																	<input type="hidden" name="cmd" value="_cart">
																	<input type="hidden" name="add" value="1">
																	<input type="hidden" name="business" value=" ">
																	<input type="hidden" name="item_name" value="Black Basic Shorts">
																	<input type="hidden" name="amount" value="30.99">
																	<input type="hidden" name="discount_amount" value="1.00">
																	<input type="hidden" name="currency_code" value="USD">
																	<input type="hidden" name="return" value=" ">
																	<input type="hidden" name="cancel_return" value=" ">
																	<input type="submit" name="submit" value="Add to cart" class="button">
																</fieldset>
															</form>
														</div>
																			
									</div>
								</div>
							</div>
						 <div class="col-md-3 product-men single">
								<div class="men-pro-item simpleCart_shelfItem">
									<div class="men-thumb-item">
										<img src="images/s6.jpg" alt="" class="pro-image-front">
										<img src="images/s6.jpg" alt="" class="pro-image-back">
											<div class="men-cart-pro">
												<div class="inner-men-cart-pro">
													<a href="single.html" class="link-product-add-cart">Quick View</a>
												</div>
											</div>
											<span class="product-new-top">New</span>
											
									</div>
									<div class="item-info-product ">
										<h4><a href="single.html">Aero Canvas Loafers  </a></h4>
										<div class="info-product-price">
											<span class="item_price">$120.99</span>
											<del>$199.71</del>
										</div>
										<div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
															<form action="#" method="post">
																<fieldset>
																	<input type="hidden" name="cmd" value="_cart">
																	<input type="hidden" name="add" value="1">
																	<input type="hidden" name="business" value=" ">
																	<input type="hidden" name="item_name" value="Aero Canvas Loafers">
																	<input type="hidden" name="amount" value="30.99">
																	<input type="hidden" name="discount_amount" value="1.00">
																	<input type="hidden" name="currency_code" value="USD">
																	<input type="hidden" name="return" value=" ">
																	<input type="hidden" name="cancel_return" value=" ">
																	<input type="submit" name="submit" value="Add to cart" class="button">
																</fieldset>
															</form>
														</div>
																			
									</div>
								</div>
						</div>
					   <div class="col-md-3 product-men single">
								<div class="men-pro-item simpleCart_shelfItem">
									<div class="men-thumb-item">
										<img src="images/w7.jpg" alt="" class="pro-image-front">
										<img src="images/w7.jpg" alt="" class="pro-image-back">
											<div class="men-cart-pro">
												<div class="inner-men-cart-pro">
													<a href="single.html" class="link-product-add-cart">Quick View</a>
												</div>
											</div>
											<span class="product-new-top">New</span>
											
									</div>
									<div class="item-info-product ">
										<h4><a href="single.html">Ankle Length Socks</a></h4>
										<div class="info-product-price">
											<span class="item_price">$100.99</span>
											<del>$159.71</del>
										</div>
										<div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
															<form action="#" method="post">
																<fieldset>
																	<input type="hidden" name="cmd" value="_cart">
																	<input type="hidden" name="add" value="1">
																	<input type="hidden" name="business" value=" ">
																	<input type="hidden" name="item_name" value="Ankle Length Socks">
																	<input type="hidden" name="amount" value="30.99">
																	<input type="hidden" name="discount_amount" value="1.00">
																	<input type="hidden" name="currency_code" value="USD">
																	<input type="hidden" name="return" value=" ">
																	<input type="hidden" name="cancel_return" value=" ">
																	<input type="submit" name="submit" value="Add to cart" class="button">
																</fieldset>
															</form>
														</div>
																			
									</div>
								</div>
							</div>
							<div class="clearfix"> </div>
					<!--//slider_owl-->
		         </div>
	        </div>
 </div>
<!--//single_page-->
<!--/grids-->



</div>
</div>
</div>


	<jsp:include page="footer.jsp" />	
	
<script type="text/javascript">
var x = setInterval(function() {


	var elementsToAdd = document.getElementsByClassName("demo");
	for (i = 0; i < elementsToAdd.length; i++) {
	var getDate = elementsToAdd[i].id;
	if (!getDate) {
	continue;
	}
	//console.log("Debugging only: " + getDate);
	var countdownDate = new Date(getDate).getTime();
	var now = new Date().getTime();
	var distance = countdownDate - now;
	var days = Math.floor(distance / (1000 * 60 * 60 * 24));
	var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
	var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
	var seconds = Math.floor((distance % (1000 * 60)) / 1000);


	       if (distance < 0) {
	elementsToAdd[i].innerHTML = "EXPIRED";
	}
	       else{
	        elementsToAdd[i].innerHTML = days + "d " + hours + "h " + minutes + "m " + seconds + "s ";
	       }
	}
	}, 1000);
	</script>

</body>
</html>