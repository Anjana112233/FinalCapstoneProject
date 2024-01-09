<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/detail.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<jsp:include page="../include/header.jsp"/>
    <div class="container mt-5">
    <h1 class="mb-4 text-dark">Your Shopping Cart</h1>
    </div>

    <c:if test="${not empty cartItems}">
     <table class="table">
            <thead>
                <tr>
                    <th>Pic</th>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cartItem" items="${cartItems}">
                    <tr>
                        <td><img src="${cartItem.product.imageUrl}" style="max-width:100px"></td>
                        <td>${cartItem.product.productName}</td>
                        <td>${cartItem.quantity}</td>
                        <td>${cartItem.product.price}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <a href="/cart/checkout" class="btn btn-primary">Checkout</a>
    </c:if>

    <c:if test="${empty cartItems}">
     <p>Your shopping cart is empty.</p>
    </c:if>


<jsp:include page="../include/footer.jsp"/>

