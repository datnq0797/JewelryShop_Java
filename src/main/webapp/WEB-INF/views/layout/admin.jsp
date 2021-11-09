<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/views/layout/user/taglib.jsp"%>
    <%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Product Admin - Dashboard HTML Template</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
    <!-- https://fonts.google.com/specimen/Roboto -->
    <link rel="stylesheet" href="<c:url value="/assets/admin/css/fontawesome.min.css"/>">
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="<c:url value="/assets/admin/css/bootstrap.min.css"/>">
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="<c:url value="/assets/admin/css/templatemo-style.css"/>">
    <!--
	Product Admin CSS Template
	https://templatemo.com/tm-524-product-admin
	-->
</head>

<body id="reportsPage">
    <div class="" id="home">
       <%@include file="/WEB-INF/views/layout/admin/header.jsp"%>

        <div class="container">
            <div class="row">
                <div class="col">
                    <p class="text-white mt-5 mb-5">Welcome back, <b>Admin</b></p>
                </div>
            </div>
            <!-- row -->
            <div class="row tm-content-row">
               <decorator:body></decorator:body>
                    
            </div>
                
        </div>
	</div>
        
    <%@include file="/WEB-INF/views/layout/admin/footer.jsp"%>

</body>

</html>