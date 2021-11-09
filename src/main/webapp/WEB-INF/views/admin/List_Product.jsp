<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<%@include file="/WEB-INF/views/layout/user/taglib.jsp"%>
<body>
<div class="container mt-5">
      <div class="row tm-content-row">
        <div class="col-sm-12 col-md-12 col-lg-8 col-xl-8 tm-block-col">
          <div class="tm-bg-primary-dark tm-block tm-block-products">
            <div class="tm-product-table-container">
              <table class="table table-hover tm-table-small tm-product-table">
                <thead>
                  <tr>
                    <th scope="col">&nbsp;</th>
                    <th scope="col">Mã sản phẩm</th>
                    <th scope="col">Tên sản phẩm</th>
                    <th scope="col">Giá</th>
                    <th scope="col">Size</th>
                    <th scope="col">&nbsp;</th>
                    
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${ products }" varStatus="loop">
                  <tr>
                    <th scope="row"><input type="checkbox" /></th>
                    <td>${item.id }</td>
                    <td>${item.name }</td>
                    <td>${item.price }</td>
                    <td>${item.sizes }</td>
                    <td>
                      <a href="<c:url value="List_Product/${item.id }"/>" class="tm-product-delete-link">
                        <i class="far fa-trash-alt tm-product-delete-icon"></i>
                      </a>
                    </td>
                    <td>
                      <a href="<c:url value="edit_Product/${item.id }"/>" class="fas fa-coffee">
                       	Edit
                      </a>
                    </td>
                  </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
            <!-- table container -->
            <a
              href="add-product"
              class="btn btn-primary btn-block text-uppercase mb-3">Add new product</a>
            <button class="btn btn-primary btn-block text-uppercase">
              Delete selected products
            </button>
          </div>
        </div>
        
        
        <div class="col-sm-12 col-md-12 col-lg-4 col-xl-4 tm-block-col">
          <div class="tm-bg-primary-dark tm-block tm-block-product-categories">
            <h2 class="tm-block-title">Product Categories</h2>
            <div class="tm-product-table-container">
              <table class="table tm-table-small tm-product-table">
                <tbody>
                 <c:forEach var="item" items="${ categorys }" varStatus="loop">
                  <tr>
                    <td class="tm-product-name">${item.name }</td>
                    <td class="text-center">
                      <a href="#" class="tm-product-delete-link">
                        <i class="far fa-trash-alt tm-product-delete-icon"></i>
                      </a>
                    </td>
                  </tr>
                 </c:forEach>
                </tbody>
              </table>
            </div>
            <!-- table container -->
            <button class="btn btn-primary btn-block text-uppercase mb-3" 
            onclick="window.location.href='/trang-admin/Add_Product'"
            >
              Thêm categorys
            </button>
          </div>
        </div>
      </div>
    </div>
        
    

</body>
