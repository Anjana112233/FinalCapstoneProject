<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/global-style.css">
<jsp:include page="../include/header.jsp"/>

<section class="search-page bg-light1 pt-5 pb-5">
    <div class="container text-center">
        <h1 class="pb-1">Product search by name</h1>
        <form action="/product/search" class="row justify-content-center">
            <div class="col-12 col-md-6">
                <label for="productNameSearch" class="form-label visually-hidden">Product Name</label>
                <div class="input-group">
                    <input type="text" name="productNameSearch" class="form-control" placeholder="Search by product Name" value="${search}">
                    <button class="btn btn-outline-secondary" type="submit">
                        &#128269; <!-- Unicode character for magnifier glass -->
                    </button>
                </div>
            </div>
        </form>


        <c:if test="${not empty productsVar}">
            <h1> Products Found ${productsVar.size()}</h1>
              <table class="table table-white-background">
                   <tr>
                        <td>Id</td>
                        <td>Product Name</td>
                         <td>Product Description</td>
                          <td>Image</td>
                          <td>Price</td>
                          <td>Edit</td>
                          <td>Detail</td>

                   </tr>
                   <c:forEach items="${productsVar}" var="product">
                     <tr>
                        <td>${product.id}</td>
                        <td>${product.productName}</td>
                        <td>${product.productDescription}</td>
                        <td><img src="${product.imageUrl}" style="max-width:100px"></td>
                        <td>${product.price}</td>

                         <td><a href="/product/edit/${product.id}">Edit</a></td>
                         <td><a href="/product/detail?id=${product.id}">Detail</a></td>
                     </tr>
                  </c:forEach>
                  </table>
                   </c:if>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>
