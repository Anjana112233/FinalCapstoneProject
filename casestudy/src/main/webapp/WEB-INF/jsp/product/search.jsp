<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/global-style.css">
<jsp:include page="../include/header.jsp"/>

<section class="search-page bg-light1 pt-5 pb-5">
    <div class="container text-center">
        <h1 class="pb-1">Welcome to Himalayan Traditional Store</h1>
        <form action="/product/search" class="row justify-content-center">
            <div class="col-12 col-md-6">
                <label for="productNameSearch" class="form-label visually-hidden">Product Name</label>
                <div class="input-group">
                    <input type="text" name="productNameSearch" class="form-control" placeholder="Search by product Name" value="${search}">
                    <button class="btn btn-outline-secondary" type="submit">&#128269;</button>
                </div>
            </div>
        </form>
    </div>
</section>

<section class= "search-page row align-items-end" >
    <div class="container-fluid  bg-transparent d-flex justify-content-around">
         <div class="container">
            <div class="row justify-content-center">
                <c:forEach items="${productsVar}" var="product">
                    <div class="col-12 col-md-4 mb-1 d-flex">
                        <div class="card text-dark">
                            <img class="card-img-top" src="${product.imageUrl}" class="img-fluid" style="max-width: 300px; height: 200px; ">
                            <div class="card-body text-center">
                                <!-- <p class="card-text"><b>Product ID:</b> ${product.id}</p> -->
                                <p class="card-text"><b>Product Name:</b> ${product.productName}</p>
                                <p class="card-text"><b>Product Description:</b> ${product.productDescription}</p>
                                <p class="card-text"><b>Price:</b> ${product.price}</p>
                                <sec:authorize access="hasAnyAuthority('ADMIN')">
                                    <p class="card-title"><a href="/product/edit/${product.id}">Edit</a></p>
                                </sec:authorize>
                                <p class="card-title"><a href="/product/detail?id=${product.id}">Detail</a></p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
       </div>
         </div>
    </section>
 <jsp:include page="../include/footer.jsp"/>
