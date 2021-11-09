<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<%@include file="/WEB-INF/views/layout/user/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm sản phẩm</title>
</head>
<body>
	<div class="container tm-mt-big tm-mb-big">
		<div class="row">
			<div class="">
				<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
					<div class="row">
						<div class="col-12">
							<h2 class="tm-block-title d-inline-block">update Product</h2>
						</div>
					</div>
					<div class="row tm-edit-product-row">
						<form:form action="add-product" method="POST"
							modelAttribute="product">

							<div class="form-group mb-3">
								<label for="name">Tên sản phẩm </label>

								<form:input type="text" class="form-control validate" path="name"
									placeholder="${products.name }" />


							</div>
							<div class="form-group mb-3">
								<label for="size">size</label>
								<form:input type="text" class="form-control validate" path="sizes"
									placeholder="${products.size }" />
							</div>


							<div class="form-group mb-3">
								<label for="category">Category</label>

								<form:select id="isCate" path="id_category" class="custom-select tm-select-accounts">
									<c:forEach var="item" items="${categorys}">
										<form:option value="${item.id}">${item.name}</form:option>
									</c:forEach>
								</form:select>

							</div>

							<div class="form-group mb-3 col-xs-12 col-sm-6">
								<label for="Giá">Giá</label>
								<form:input type="text" class="form-control validate" path="price"
									placeholder="giá " />
							</div>
							<div class="form-group mb-3 col-xs-12 col-sm-6">
								<label for="sale">Sale </label>
								<form:input type="text" class="form-control validate" path="sale"
									placeholder="sale" />
							</div>

							<div class="form-group ">
								<label for="Title">Title </label>
								<form:textarea type="text" class="form-control validate" path="title" cols="40"
									placeholder="title" />
							</div>

							<div class="form-group mb-3 col-xs-12 col-sm-6">
								<label for="highlight">highlight</label>
								<form:input type="number" class="form-control validate" path="highlight"
									placeholder="highlight" />
							</div>


							<div class="form-group mb-3 col-xs-12 col-sm-6">
								<label for="new_product">new_product </label>
								<form:input type="number" class="form-control validate" path="new_product"
									placeholder="new_product" />
							</div>


							<div class="form-group ">
								<label for="stock">Chi tiết sản phẩm </label>
								<form:textarea type="text" class="form-control validate" path="details" 
									placeholder="chi tiết" />
							</div>


							<div class="col-12">
								<button type="submit"
									class="btn btn-primary btn-block text-uppercase">update
									Product Now</button>
							</div>

						</form:form>
					</div>
				</div>
			</div>
			
			
			
			
			
		</div>
	</div>
</body>