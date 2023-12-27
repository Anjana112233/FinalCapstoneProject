<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/detail.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<jsp:include page="../include/header.jsp"/>
<div class="container-fluid d-flex align-items-center justify-content-center" style="min-height: 78vh;">
    <section>
        <table>
            <div class="card" style="width: 18rem;">
                <img class="card-img-top" style="max-height: 200px" src="${product.imageUrl}" alt="Card image cap">
                <div class="card-body text-center">
                    <h5 class="card-title"><a href="/product/detail?id=${product.id}">${product.productName}</a></h5>
                    <p class="card-text">${product.productDescription} </p>
                 <div class="container">
                 		<span class="fa fa-star checked"></span>
                 		<span class="fa fa-star checked"></span>
                 		<span class="fa fa-star checked"></span>
                 		<span class="fa fa-star checked"></span>
                 		<span class="fa fa-star checked"></span>
                 	</div>
                    <p class="card-test"> Price= $${product.price} </p>
                    <a href="/cart/additem?id=${product.id}" class="btn btn-primary">Add to cart</a>
                </div>
            </div>
        </table>
    </section>
</div>
<jsp:include page="../include/footer.jsp"/>
