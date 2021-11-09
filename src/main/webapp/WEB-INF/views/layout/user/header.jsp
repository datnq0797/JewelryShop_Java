<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<%@include file="/WEB-INF/views/layout/user/taglib.jsp"%>
<header id="header">
	<div class="row">
		<div class="span4">
			<h1>
				<a class="logo" href="<c:url value="/trang-chu"/>"><span>Twitter Bootstrap
						ecommerce template</span> <img
					src="<c:url value="/assets/user/img/logonew.png"/>"
					alt="bootstrap sexy shop"> </a>
			</h1>
		</div>
		<div class="span4">
			
		</div>
		<div class="span4 alignR">
			<p>
				<br> <strong> SĐT liên hệ: 0779878661  </strong><br>
				<br>
			</p>
			<c:set var="count" value="${TotalQuantyCart}"></c:set>
			<c:if test="${count <=0} ">
				<c:set var="count" value="0" />
			</c:if>
			
			<span class="btn btn-mini">[${count}] <span
				class="icon-shopping-cart"></span></span> 
		</div>
	</div>
</header>

<!--
Navigation Bar Section 
-->
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<a data-target=".nav-collapse" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="nav-collapse">
				<ul class="nav">
					<c:forEach var="item" items="${menu}" varStatus="index">
						<c:if test="${index.first }">
							<li class="item active"><a href="<c:url value="/${item.url}"/>">${item.name}</a></li>
						</c:if>
						<c:if test="${not index.first }">
							<li class="item"><a href="<c:url value="/${item.url }"/>">${item.name}</a></li>
						</c:if>
					</c:forEach>

				</ul>
				
				
				
				
				
				<ul class="nav pull-right">
					<c:if test="${empty LoginInfo }">
						<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"><span class="icon-lock"></span>
							Login <b class="caret"></b></a>
						<div class="dropdown-menu">
							<form class="form-horizontal loginFrm">
								<div class="control-group">
									<input type="text" class="span2" id="inputEmail"
										placeholder="Email">
								</div>
								<div class="control-group">
									<input type="password" class="span2" id="inputPassword"
										placeholder="Password">
								</div>
								<div class="control-group">
									<label class="checkbox"> <input type="checkbox">
										Remember me
									</label>
									<button type="submit" class="shopBtn btn-block">Sign
										in</button>
								</div>
							</form>
						</div></li>
					</c:if>
					<c:if test="${not empty LoginInfo }">
						<li><a href="#">${LoginInfo.display_name }<b class="caret"></b></a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>