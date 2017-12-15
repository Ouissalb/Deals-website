
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
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="js/jquery.easyPaginate.js"></script>		
		
		
		
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


<!-- /new_arrivals --> 
	<div class="new_arrivals_agile_w3ls_info"> 
		<div class="container">
		    <h3 class="wthree_text_info">Your <span>Deals</span></h3>		
				<div id="horizontalTab">
						<ul class="resp-tabs-list">
							<li></li>
							<li></li>
							<li></li>
							<li></li>
						</ul>
					<div class="resp-tabs-container">
					<!--/tab_one-->
						<div class="tab1">
							
							
						<div id="easyPaginate">
							<c:forEach var="sujet" items="${sujets}">
							<div class="col-md-3 product-men">
							
								<div class="men-pro-item simpleCart_shelfItem">
								
									<div class="men-thumb-item">
										<img src="<%=request.getContextPath()%>/uploadedImages/${sujet[7]}" alt="" class="pro-image-front">
										<img src="<%=request.getContextPath()%>/uploadedImages/${sujet[7]}" alt="" class="pro-image-back">
											<!--<div class="men-cart-pro">
												 <div class="inner-men-cart-pro">
													<a href="single.html" class="link-product-add-cart">Voir plus</a>
												</div> 
											</div>-->
											<span class="product-new-top demo" id="${sujet[2]}"> </span>																								
									</div>
									<div class="item-info-product ">
										<s:form action="/manageDeal.action">
										    <input type="hidden" value="${sujet[0]}" name="id_sujet">
											<h4><a href="#">
											<input type="submit" value="${sujet[12]}" style="background:none;border:none;">
											</a></h4>
										</s:form>
										<div class="info-product-price">
										
											
											<c:choose>
												  <c:when test="${empty sujet[10] or sujet[10] == '0'}">
												    <span class="item_price">${sujet[9]} DH</span>
												  </c:when>
							
												  <c:otherwise>
												     <span class="item_price">${sujet[9]} DH</span>
													<del>${sujet[8]}</del>					    
												  </c:otherwise>
												</c:choose>
												
											
										</div>											
									</div>
									<div class="product-new-top-left">  ${sujet[10]}<i class="material-icons move-bottom">person_add</i></div>
								</div>
							</div>
						</c:forEach>
					</div>
							
							
							
							
							
						
						
							<div class="clearfix"></div>
						</div>
					</div>
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
	<script type="text/javascript">
    $('#easyPaginate').easyPaginate({
        paginateElement: 'div',
        elementsPerPage: 3,
        effect: 'climb'
    });
    </script>

</body>
</html>