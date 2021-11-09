<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/user/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanh toán</title>
</head>
<body>
	<div class="row">
		
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">Người dùng</li>
			</ul>
			
			<hr class="soft" />

			<div class="row">
				<div class="span9">
					<div class="well">
						<h5>Đăng ký tài khoản</h5>
						
						
						<form:form action="checkout" method="POST" 
						modelAttribute="bills" class="form-horizontal">
							<h3>Thanh toán đơn hàng</h3>
							
							<div class="control-group">
								<label class="control-label">Họ tên <sup>*</sup></label>
								<div class="controls">
									
									<form:input type="text" class="span3" path="display_name"
										placeholder="Mời nhập họ tên" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Email <sup>*</sup></label>
								<div class="controls">
									<form:input type="text" placeholder=" Mời nhập Email"  path="user" class="span3"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Liên hệ <sup>*</sup></label>
								<div class="controls">
									<form:input type="text" placeholder=" Mời nhập số điện thoại" path="phone" class="span3"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Địa chỉ <sup>*</sup></label>
								<div class="controls">
									<form:textarea  path="address" cols="30" row="5"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Ghi chú <sup>*</sup></label>
								<div class="controls">
									<form:textarea  path="note" cols="30" row="5"/>
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<input type="submit" name="submitAccount" value="Register"
										class="shopBtn exclusive">
								</div>
							</div>
						</form:form>
					</div>
				</div>


			</div>

		</div>
	</div>
</body>
</html>