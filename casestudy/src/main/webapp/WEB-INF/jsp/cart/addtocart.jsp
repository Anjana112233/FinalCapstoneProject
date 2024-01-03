<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/detail.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<jsp:include page="../include/header.jsp"/>

<div class="container-fluid d-flex align-items-center justify-content-center" style="min-height: 78vh;">
    <section>
        <div class="row">
            <!-- Product Image (Left Side) -->
            <div class="col-md-2">
                <img class="img-fluid" src="${product.imageUrl}" alt="Product Image">
            </div>

            <!-- Product Details (Middle) -->
            <div class="col-md-4">
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

                    <!-- Dropdown for Quantity -->
                    <label for="quantity">Quantity: </label>
                    <select id="quantity" name="quantity">
                        <c:forEach begin="1" end="9" var="quantityOption">
                            <option value="${quantityOption}" ${quantityOption == orderdetail.quantityordered ? 'selected' : ''}>
                                ${quantityOption}
                            </option>
                        </c:forEach>
                    </select>

                    <!-- Add to Cart Button -->
                   <a href="/cart/viewcart?id=${product.id}&quantity=${orderdetail.quantityordered}" class="btn btn-primary">viewcart</a>
                </div>
            </div>

            <!-- Product Price (Right Side) -->
            <div class="col-md-4">
                <p class="card-test"> Price: $${product.price} </p>
            </div>
        </div>
    </section>
</div>

<jsp:include page="../include/footer.jsp"/>
