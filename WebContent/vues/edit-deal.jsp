<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link href="css/custom-post-deal.css" rel="stylesheet" type="text/css" media="all" />
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
</head>
<body>
<jsp:include page="header.jsp" />	


<br/>
<br/>
<h2> &nbsp Edit deal</h2>
<br />
<div class="inner contact">
                
                <div>                 
                    <s:form id="contact-us" method="post" action="updatedeal.action" validate="true" enctype = "multipart/form-data">
                        <!-- Left Inputs -->
                        <div class="col-xs-6">
                            <input type="hidden" name="id_sujet" value="${sujetDetails[0] }">
                            <input type="text" name="title" id="name" required="required" class="form" value="${sujetDetails[12]}"/>
                            
                            <input type="date" name="dateEnd" id="dateEnd" required="required" class="form" value="${sujetDetails[2]}" />
                            
                            <label for="number">Price</label>
                            <input type="number" name="price" min="100" max="20000" value="${sujetDetails[8]}"></input>
                            
                            &nbsp &nbsp &nbsp

							<br/>
							
							
							
							
							<label for="rubrique">Rubrique :</label>

							<select name="rubrique" >
							    <c:forEach var="item" items="${rubriques}">
							    	 <c:choose>
										<c:when test="${ item[0] == sujetDetails[6]}">
											<option selected="selected" value="${item[0]}">${item[1]}</option>		    
										</c:when>
									    <c:otherwise>
									    	<option value="${item[0]}">${item[1]}</option>				    
									    </c:otherwise>
									</c:choose>
							    </c:forEach>
							</select>
							
							
                        </div>
                        <!-- End Left Inputs -->
                        
                        <!-- Right Inputs -->
                        <div class="col-xs-6">
                         
                            <textarea name="description" id="message" class="form textarea"  placeholder="Description">${sujetDetails[1]}</textarea>
                             <div id = "drag">
                        	 <input type="file" name = "myFile">
                        	 <br/><br/>
 								
                       		 </div>
                       		 
                       		  
                       		 
                        </div>
                        
                        <!-- End Right Inputs -->
                        
                        <!-- Bottom Submit -->
                        <div class="relative fullwidth col-xs-12">
                         
                            <button type="submit" id="submit" name="submit" class="form-btn semibold">Edit deal</button> 
                        </div>
                        
                        <!-- End Bottom Submit -->
                        
                        <div class="clear"></div>
                    </s:form>

                    <!-- Your Mail Message -->
                    <div class="mail-message-area">
                        <!-- Message -->
                        <div class="alert gray-bg mail-message not-visible-message">
                            <strong>Thank You !</strong> Your email has been delivered.
                        </div>
                    </div>

                </div><!-- End Contact Form Area -->
            </div><!-- End Inner -->

<br/><br/>
<div  id = "credits" ><center> Form designed by: <a href="http://shuvohabib.com" target="blank">Shuvo Habib </a> </center></div>


<jsp:include page="footer.jsp" />


</body>
</html>